<template>
    <a-card style="margin-bottom:1em">
        <a-card-grid style="width: 25%; text-align: center">
            <a-statistic title="管理桥梁" suffix="座" :value="112893" />
        </a-card-grid>
        <a-card-grid style="width: 25%; text-align: center">
            <a-statistic title="已完成基本卡片" suffix="座" :value="112893" />
        </a-card-grid>
        <a-card-grid style="width: 25%; text-align: center">
            <a-statistic title="已完成初始检查" suffix="座" :value="112893" />
        </a-card-grid>
        <a-card-grid style="width: 25%; text-align: center">
            <a-statistic title="已完成定期检查" suffix="座" :value="112893" />
        </a-card-grid>
      </a-card>
    <a-button class="operator-btn" @click="visible = true">添加单位</a-button>
    <a-table :columns="columns" :data-source="dataSource">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.route_no)"
                >
                  <a>删除</a>
                </a-popconfirm>
              </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="单位"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        
        <a-input class="input-cpn" pattern="[0-9]*" v-model:value="modalValue.unit_no" placeholder="单位编号" />
        <a-input class="input-cpn" v-model:value="modalValue.unit_name" placeholder="单位名称" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';

const columns = [
    {
        title: '单位编号',
        dataIndex: 'unit_no',
    },
    {
        title: '单位名称',
        dataIndex: 'unit_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
    
];

interface Unit {
    unit_no:string
    unit_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_unit_no = ref("")
        const dataSource: Ref<Unit[]> = ref([])

        let units = ref([])

        const checkInput = () => {
            if (modalValue.unit_no.length == 0 || modalValue.unit_name.length == 0 )
                return false

            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.unit_no = ""
            modalValue.unit_name =""
            old_unit_no.value=""

            getUnits()
        }

        const modalValue = reactive({
            unit_no:'',
            unit_name:'',
        })

        const getUnits = () => {
            axios({
                url: 'http://localhost:3000/api/unit/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getUnits()

        const handleOk = () => {

            if (! checkInput() ) {
                error_message("请规范输入内容", "error");
                return
            }
            
            if (isUpdate.value) {
                handleUpdate()
            } else {
                handleAdd()
            }
            
        }

        const handleAdd = () => {
            axios({
                url:'http://localhost:3000/api/unit/add',
                method:"POST",
                params:{
                    unit_no:modalValue.unit_no,
                    unit_name:modalValue.unit_name,
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

        const onUpdate = (record:any) => {
            modalValue.unit_no = record.unit_no
            modalValue.unit_name = record.unit_name
            old_unit_no.value = record.unit_no
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/unit/update',
                method:"POST",
                params:{
                    old_unit_no:old_unit_no.value,
                    new_unit_no:modalValue.unit_no,
                    unit_name:modalValue.unit_name,
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

        const onDelete = (unit_no : any) => {
            axios({
                url:'http://localhost:3000/api/unit/delete',
                method:"POST",
                params: {
                    unit_no: unit_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getUnits()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            onUpdate,
            units,
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
        margin: .5em;
        height: 2.5em;
    }
</style>
  
  