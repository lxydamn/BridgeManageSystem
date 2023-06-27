<template>
  <a-button class="operator-btn" @click="visible = true">添加养护处治记录</a-button>

  <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}">
    <template #bodyCell="{column, record}">
      <template v-if="column.dataIndex === 'operation'">
        <a-popconfirm
            v-if="dataSource.length"
            title="确认要删除吗？"
            ok-text="确认"
            cancel-text="取消"
            @confirm="onDelete(record.tre_rcd_no)"
        >
          <a>删除</a>
        </a-popconfirm>
      </template>
    </template>
  </a-table>

  <a-modal
      v-model:visible="visible"
      title="养护处治记录"
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
        v-model:value="modalValue.tre_type"
        placeholder="处治类别"
    />
    <a-input
        class="input-cpn"
        v-model:value="modalValue.tre_rea"
        placeholder="处治原因"
    />
    <a-input
        class="input-cpn"
        v-model:value="modalValue.tre_rge"
        placeholder="处治范围"
    />
    <a-input-number
        class="input-cpn"
        v-model:value="modalValue.pro_fee"
        placeholder="工程费用"
    />
    <a-input-number
        class="input-cpn"
        v-model:value="modalValue.ori_fee"
        placeholder="经费来源"
    />
    <a-input
        class="input-cpn"
        v-model:value="modalValue.tre_qlt_aes"
        placeholder="处治质量评定"
    />
    <a-date-picker
        class="input-cpn"
        style="margin: .5em"
        value-format="YYYY-MM-DD"
        format="YYYY-MM-DD"
        :locale="locale"
        placeholder="评定时间"
        v-model:value="modalValue.tre_time"
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
    title: "养护处治记录编号",
    dataIndex: 'tre_rcd_no',
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
    title: '处治类别',
    dataIndex: 'tre_type',
    ellipsis: true,
  },
  {
    title: '处治原因',
    dataIndex: 'tre_rea',
    ellipsis: true,
  },
  {
    title: '处治范围',
    dataIndex: 'tre_rge',
    ellipsis: true,
  },
  {
    title: '工程费用',
    dataIndex: 'pro_fee',
    ellipsis: true,
  },
  {
    title: '经费来源',
    dataIndex: 'ori_fee' ,
    ellipsis: true,
  },
  {
    title: '处治质量评定',
    dataIndex: 'tre_qlt_aes' ,
    ellipsis: true,
  },
  {
    title: '处治时间',
    dataIndex: 'tre_time' ,
    ellipsis: true,
  },
  {
    title: '操作',
    dataIndex: 'operation',
  },

];

interface MaintainRecord {
  bridge_name: string
  card_no: string
  tre_rcd_no:string
  tre_type:string 
  tre_rea:string
  tre_rge:string
  pro_fee:string
  ori_fee:string 
  tre_qlt_aes:string 
  tre_time: string
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
    const dataSource: Ref<MaintainRecord[]> = ref([])
    const modalValue = reactive({
      card_no:'',
      tre_type:'',
      tre_rea:'',
      tre_rge:'',
      pro_fee:'',
      ori_fee:'',
      tre_qlt_aes:'',
      tre_time: ref<Dayjs>(),
    })
    let bridges: Ref<BridgeToCard[]> = ref([])

    const checkInput = () => {
      if (
          modalValue.card_no.length == 0 ||
          modalValue.tre_type.length == 0 ||
          modalValue.tre_rea.length == 0 ||
          modalValue.tre_rge.length == 0 ||
          modalValue.pro_fee.length == 0 ||
          modalValue.ori_fee.length == 0 ||
          modalValue.tre_qlt_aes.length == 0 ||
          modalValue.tre_time == undefined 
      ) {
        error_message("请检查输入", 'error')
        return false
      }

      return true
    }

    const cleanInput = () => {
      visible.value = false

      modalValue.card_no = ""
      modalValue.tre_type= ''
      modalValue.tre_rea= ''
      modalValue.tre_rge= ''
      modalValue.pro_fee= ''
      modalValue.ori_fee= ''
      modalValue.tre_qlt_aes= ''
      modalValue.tre_time = undefined
      
      getMaintainRecord()
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

    const getMaintainRecord = () => {
      axios({
        url: 'http://localhost:3000/api/record/maintain/withbc',
        method:'GET',
      }).then((resp) => {
        dataSource.value = resp.data
      })
    }
    getMaintainRecord()

    const handleOk = () => {
      if (! checkInput() ) {
        error_message("请规范输入内容", "error");
        return
      }

      handleAdd()
    }

    const handleAdd = () => {
      axios({
        url:'http://localhost:3000/api/record/maintain/add',
        method:"POST",
        params:{
          card_no: modalValue.card_no,
          tre_type:modalValue.tre_type,
          tre_rea:modalValue.tre_rea,
          tre_rge:modalValue.tre_rge,
          pro_fee:modalValue.pro_fee,
          ori_fee:modalValue.ori_fee,
          tre_qlt_aes:modalValue.tre_qlt_aes,
          tre_time: modalValue.tre_time,
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


    const onDelete = (tre_rcd_no : any) => {
      axios({
        url:'http://localhost:3000/api/record/maintain/delete',
        method:"POST",
        params: {
          tre_rcd_no: tre_rcd_no,
        }
      }).then((resp) => {
        error_message(resp.data.error_info, resp.data.error_info)
        getMaintainRecord()
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

