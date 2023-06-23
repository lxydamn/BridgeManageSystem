<template>
    <a-button class="operator-btn" @click="visible = true">添加类型</a-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.type_no)"
                >
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="桥梁类型"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            pattern="[0-9]*"
            v-model:value="modalValue.type_no"
            placeholder="桥梁类型编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.type_name"
            placeholder="桥梁类型名称"
        />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';

const columns = [
    {
        title: "类型编号",
        dataIndex: 'type_no',
    },
    {
        title: '类型名称',
        dataIndex: 'type_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },

];

interface BridgeType {
    type_no:string
    type_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_type_no = ref("")
        const dataSource: Ref<BridgeType[]> = ref([])

        let units = ref([])

        const checkInput = () => {
            if (modalValue.type_no.length == 0 || modalValue.type_name.length == 0 )
                return false

            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.type_no = ""
            modalValue.type_name =""
            old_type_no.value=""

            getTypes()
        }

        const modalValue = reactive({
            type_no:'',
            type_name:'',
        })

        const getTypes = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeType/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getTypes()

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
                url:'http://localhost:3000/api/bridgeType/add',
                method:"POST",
                params:{
                    type_no:modalValue.type_no,
                    type_name:modalValue.type_name,
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
            modalValue.type_no = record.type_no
            modalValue.type_name = record.type_name
            old_type_no.value = record.type_no
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bridgeType/update',
                method:"POST",
                params:{
                    old_type_no:old_type_no.value,
                    new_type_no:modalValue.type_no,
                    type_name:modalValue.type_name,
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

        const onDelete = (type_no : any) => {

            axios({
                url:'http://localhost:3000/api/bridgeType/delete',
                method:"POST",
                params: {
                    type_no: type_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getTypes()
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

