<template>
    <a-button class="operator-btn" @click="visible = true">添加路线</a-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 70vh">
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
        title="路线"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input class="input-cpn" pattern="[0-9]*" v-model:value="modalValue.route_no" placeholder="路线编号" />
        <a-input class="input-cpn" v-model:value="modalValue.route_name" placeholder="路线名称" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';

const columns = [
    {
        title: "路线编号",
        dataIndex: 'route_no',
    },
    {
        title: '路线名称',
        dataIndex: 'route_name',
        ellipsis: true,
    },
    {
        title: '路线级别',
        dataIndex: "route_rank",
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
    
];

interface Route {
    route_no:string
    route_name: string
    route_rank:string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_route_no = ref("")
        const dataSource: Ref<Route[]> = ref([])

        let units = ref([])

        const checkInput = () => {
            if (modalValue.route_no.length == 0 || modalValue.route_name.length == 0 ||
                modalValue.route_rank.length == 0
            )
                return false

            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.route_no = ""
            modalValue.route_name =""
            modalValue.route_rank =""
            old_route_no.value=""

            getRoutes()
        }

        const modalValue = reactive({
            route_no:'',
            route_name:'',
            route_rank:'',
        })

        const getRoutes = () => {
            axios({
                url: 'http://localhost:3000/api/route/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getRoutes()

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
                url:'http://localhost:3000/api/route/add',
                method:"POST",
                params:{
                    route_no:modalValue.route_no,
                    route_name:modalValue.route_name,
                    route_rank:modalValue.route_rank,
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
            modalValue.route_no = record.route_no
            modalValue.route_name = record.route_name
            modalValue.route_rank = record.route_rank
            old_route_no.value = record.route_no
            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/route/update',
                method:"POST",
                params:{
                    old_route_no:old_route_no.value,
                    new_route_no:modalValue.route_no,
                    route_name:modalValue.route_name,
                    route_rank:modalValue.route_rank,
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

        const onDelete = (route_no : any) => {

            axios({
                url:'http://localhost:3000/api/route/delete',
                method:"POST",
                params: {
                    route_no: route_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getRoutes()
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
  
  