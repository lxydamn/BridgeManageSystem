<template>

    <a-button class="operator-btn" @click="visible = true">添加桥梁</a-button>

    <a-table class="bridge-table" :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                >
                  <a>删除</a>
                </a-popconfirm>
              </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="桥梁"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input addon-before="桥梁编号" class="input-cpn" pattern="[0-9]*" v-model:value="modalValue.bridge_no" placeholder="桥梁编号" />
        <a-input addon-before="桥梁名称" class="input-cpn" v-model:value="modalValue.bridge_name" placeholder="桥梁名称" />
        <div class="select-box input-cpn">
            <span style="margin-left: .6em;">路线编号</span>
            <a-select
                ref="select"
                v-model:value="modalValue.route_no"
                style="width: 10em"
                :options="routes"
                :field-names="{label:'route_name', value:'route_no'}"
            ></a-select>
            <span>桥梁类型</span>
            <a-select
                ref="select"
                v-model:value="modalValue.type_no"
                style="width: 10em"
                :options="types"
                :field-names="{label:'type_name', value:'type_no'}"
            ></a-select>
        </div>
    </a-modal>
</template>

<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';
import {useUserStore} from "../../store/user.ts";

const columns = [
    {
        title: '桥梁编号',
        dataIndex: 'bridge_no',
    },
    {
        title: '桥梁名称',
        dataIndex: 'bridge_name',
        ellipsis: true,
    },
    {
        title: '路线编号',
        dataIndex: 'route_no',
        ellipsis: true,
    },
    {
        title: '路线名称',
        dataIndex: 'route_name',
        ellipsis: true,
    },
    {
        title: '路线等级',
        dataIndex: 'route_rank',
        ellipsis: true,
    },
    {
        title: '桥梁类型编号',
        dataIndex: 'type_no',
        ellipsis: true,
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

interface Bridge {
    bridge_no:string
    bridge_name: string
    route_no:string
    route_name:string
    route_rank:string
    type_no:string
    type_name:string
}

export default defineComponent({
    components: {

    },
    setup() {
        const userStore = useUserStore()
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_bridge_no = ref("")
        const dataSource: Ref<Bridge[]> = ref([])
        const routes = ref([])
        const types = ref([])
        const modalValue = reactive({
            bridge_no:'',
            bridge_name:'',
            type_no:'',
            route_no:'',
        })

        const checkInput = () => {
            if (modalValue.bridge_name.length == 0 || modalValue.bridge_no.length == 0 ||
                    modalValue.route_no.length == 0 || modalValue.type_no.length == 0
                )
                return false
            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.bridge_no = ""
            modalValue.route_no = ""
            modalValue.type_no = ""
            modalValue.bridge_name =""
            old_bridge_no.value=""

            getBridge()
        }

        
        const getRoutes = () => {
            axios({
                url: 'http://localhost:3000/api/route/get/all',
                method:'GET',
            }).then((resp) => {
                routes.value = resp.data
            })
        }
        getRoutes()

        const getBridge = () => {
            axios({
                url: 'http://localhost:3000/api/bridge/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getBridge()

        const getTypes = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeType/get/all',
                method:'GET',
            }).then((resp) => {
                types.value = resp.data
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
                url:'http://localhost:3000/api/bridge/add',
                method:"POST",
                params:{
                    bridge_no:modalValue.bridge_no,
                    bridge_name:modalValue.bridge_name,
                    type_no:modalValue.type_no,
                    route_no:modalValue.route_no,
                    unit_no: userStore.unit_no,
                    unit_job:'管养',
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
            modalValue.bridge_no = record.bridge_no
            modalValue.bridge_name = record.bridge_name
            modalValue.route_no = record.route_no
            modalValue.type_no = record.type_no
            old_bridge_no.value = record.bridge_no

            visible.value = true
            isUpdate.value = true
            console.log(record)
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bridge/update',
                method:"POST",
                params:{
                    old_bridge_no:old_bridge_no.value,
                    new_bridge_no:modalValue.bridge_no,
                    bridge_name:modalValue.bridge_name,
                    route_no:modalValue.route_no,
                    type_no:modalValue.type_no,
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

        const onDelete = (bridge_no : any) => {
            axios({
                url:'http://localhost:3000/api/bridge/delete',
                method:"POST",
                params: {
                    bridge_no: bridge_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getBridge()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            onUpdate,
            types,
            routes,
            onDelete,
            cleanInput,
        };
    },
});
</script>

<style>
.bridge-table{
    height: 68vh;
    margin-top: 1em;
}

.operator-btn {
    margin-bottom: .8em;
    height: 3em;
}
.select-box {
    width: 100%;
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.input-cpn {
    margin: .5em;
    height: 2.5em;
}
</style>
  
  