<template>
  <a-button class="operator-btn" @click="visible = true">添加检测历史记录</a-button>

  <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" >
    <template #bodyCell="{column, record}">
      <template v-if="column.dataIndex === 'operation'">
        <a-popconfirm
            v-if="dataSource.length"
            title="确认要删除吗？"
            ok-text="确认"
            cancel-text="取消"
            @confirm="onDelete(record.ase_rcd_no)"
        >
          <a>删除</a>
        </a-popconfirm>
      </template>
    </template>
  </a-table>

  <a-modal
      v-model:visible="visible"
      title="桥梁历史检测记录"
      ok-text="确认"
      cancel-text="取消"
      @ok="handleOk"
      @cancel="cleanInput"
  >
    <a-select
        class="input-cpn"

        v-model:value="modalValue.card_no"
        :options="bridges"
        :field-names="{label:'bridge_name', value:'card_no'}"
    ></a-select>
    <a-input
        class="input-cpn"
        v-model:value="modalValue.ase_type"
        placeholder="检测类别"
    />
    <a-input
        class="input-cpn"
        v-model:value="modalValue.ase_rst"
        placeholder="检测结果"
    />
    <a-input
        class="input-cpn"
        v-model:value="modalValue.ctr_mes"
        placeholder="处治对策"
    />
    <a-date-picker
        class="input-cpn"
        style="margin: .5em"
        value-format="YYYY-MM-DD"
        format="YYYY-MM-DD"
        :locale="locale"
        placeholder="检测时间"
        v-model:value="modalValue.ase_time"
    />

    <a-date-picker
        class="input-cpn"
        style="margin: .5em"
        value-format="YYYY-MM-DD"
        format="YYYY-MM-DD"
        :locale="locale"
        placeholder="下次检测时间"
        v-model:value="modalValue.nxt_time"
    />
  </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from "../../utils/errorMessage.ts"
import locale from "ant-design-vue/lib/time-picker/locale/zh_CN";
import type {Dayjs} from 'dayjs'
const columns = [
  {
    title: "检测记录编号",
    dataIndex: 'ase_rcd_no',
    ellipsis: true,
  },
  {
    title: '对应桥梁名称',
    dataIndex: 'bridge_name',
    ellipsis: true,
  },
  {
    title: '对应基本卡片编号',
    dataIndex: 'card_no',
    ellipsis: true,
  },
  {
    title: '检测类别',
    dataIndex: 'ase_type',
    ellipsis: true,
  },
  {
    title: '检测结果',
    dataIndex: 'ase_rst',
    ellipsis: true,
  },
  {
    title: '处治对策',
    dataIndex: 'ctr_mes',
    ellipsis: true,
  },
  {
    title: '检测时间',
    dataIndex: 'ase_time',
    ellipsis: true,
  },
  {
    title: '下次检测时间',
    dataIndex: 'nxt_time',
    ellipsis: true,
  },
  {
    title: '操作',
    dataIndex: 'operation',
  },

];

interface AssessRecord {
   ase_rcd_no: string
   bridge_name: string
   card_no: string
   ase_type: string
   ase_rst: string
   ctr_mes: string
   ase_time: string
   nxt_time: string
}
interface BridgeToCard {
  bridge_name:string
  card_no:string
}
export default defineComponent({
  components: {

  },
  setup() {
    let visible = ref(false)
    const dataSource: Ref<AssessRecord[]> = ref([])
    const modalValue = reactive({
      card_no:'',
      ase_rst:'',
      ase_type:'',
      ctr_mes:'',
      ase_time:ref<Dayjs>(),
      nxt_time: ref<Dayjs>(),
    })
    let bridges: Ref<BridgeToCard[]> = ref([])

    const checkInput = () => {
      if (
          modalValue.card_no.length == 0 ||
          modalValue.ase_rst.length == 0 ||
          modalValue.ctr_mes.length == 0 ||
          modalValue.ase_type.length == 0 ||
          modalValue.ase_time == undefined ||
          modalValue.nxt_time == undefined
      ) {
        error_message("请检查输入", 'error')
        return false
      }

      return true
    }

    const cleanInput = () => {
      visible.value = false

      modalValue.card_no = ""
      modalValue.ase_rst = ""
      modalValue.ctr_mes = ""
      modalValue.ase_time = undefined
      modalValue.nxt_time = undefined
      getAssessRecord()
    }


    const getBridgeToCard = () => {
      axios({
        url: 'http://localhost:3000/api/record/bridgeToCard/get',
        method:'GET',
      }).then((resp) => {
        bridges.value = resp.data
      })
    }
    getBridgeToCard();

    const getAssessRecord = () => {
      axios({
        url: 'http://localhost:3000/api/record/assess/withbc',
        method:'GET',
      }).then((resp) => {
        dataSource.value = resp.data
      })
    }
    getAssessRecord()

    const handleOk = () => {
      if (! checkInput() ) {
        error_message("请规范输入内容", "error");
        return
      }

      handleAdd()
    }

    const handleAdd = () => {
      axios({
        url:'http://localhost:3000/api/record/assess/add',
        method:"POST",
        params:{
          card_no: modalValue.card_no,
          ase_type: modalValue.ase_type,
          ase_rst: modalValue.ase_rst,
          ctr_mes: modalValue.ctr_mes,
          ase_time: modalValue.ase_time,
          nxt_time: modalValue.nxt_time,
        }
      }).then((resp) => {
        if (resp.data.error_info === 'success') {
          error_message("成功", "success")
          cleanInput()
        } else {
          error_message(resp.data.error_info, "error")
        }
      })
    }


    const onDelete = (ase_rcd_no : any) => {
      axios({
        url:'http://localhost:3000/api/record/assess/delete',
        method:"POST",
        params: {
          ase_rcd_no: ase_rcd_no,
        }
      }).then((resp) => {
        error_message(resp.data.error_info, resp.data.error_info)
        getAssessRecord()
      })
    }

    return {
      columns,
      dataSource,
      modalValue,
      handleOk,
      locale,
      visible,
      bridges,
      onDelete,
      cleanInput,
    };
  },
});
</script>

<style>
.operator-btn {
  margin-bottom: .8em;
  height: 3em;
}
.input-cpn {
  width: 100%;
  margin: .5em;
  height: 2.5em;
}
</style>

