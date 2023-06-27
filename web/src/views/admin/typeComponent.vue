<template>
    <a-card class="head-card">
        <p class="head-title">你当前正在配置类型为{{ $route.query.type_name }}的桥梁部件</p>
        <a-button type="primary" shape="circle" size="large" @click="visible = true">
            <template #icon><PlusOutlined /> </template>
        </a-button>
    </a-card>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8 }" style="height: 69vh">
        <template #bodyCell="{ column, record }">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm v-if="dataSource.length" title="确认要删除吗？" ok-text="确认" cancel-text="取消"
                    @confirm="onDelete(record.type_no, record.bri_cpn_no)">
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>

    <a-modal v-model:visible="visible" title="桥梁类型部件" ok-text="确认" cancel-text="取消" @ok="handleOk" @cancel="cleanInput">
        <a-select 
        class="input-cpn" 
        ref="select" 
        v-model:value="bri_cpn_no" 
        style="width: 100%;"
        :options="components" :field-names="{ label: 'bri_cpn_name', value: 'bri_cpn_no' }" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, ref } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue'
import { error_message } from '../../utils/errorMessage';
import { useRoute } from "vue-router";

const columns = [
    {
        title: "类型编号",
        dataIndex: 'type_name',
    },
    {
        title: "部件编号",
        dataIndex: 'bri_cpn_name',
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
];

interface BridgeTypeCpn {
    type_no: string
    type_name: string
    bri_cpn_no: string
    bri_cpn_name: string
}

export default defineComponent({
    components: {
        PlusOutlined,
    },

    setup() {
        const route = useRoute();
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_bri_cpn_no = ref("")
        const dataSource: Ref<BridgeTypeCpn[]> = ref([])
        let components = ref([])

        const getComponents = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeComponent/get/all',
                method: 'GET',
            }).then((resp) => {
                components.value = resp.data
            })
        }
        getComponents()

        const checkInput = () => {
            if (bri_cpn_no.value === '')
                return false
            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false
            bri_cpn_no.value = ''
            old_bri_cpn_no.value = ""
            getTypeCpns()
        }
        
        const type_no = route.query.type_no
        let bri_cpn_no = ref('')

        const getTypeCpns = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeTypeCpn/get/all',
                method: 'GET',
                params: {
                    type_no: type_no
                }
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getTypeCpns()

        const handleOk = () => {
            if (!checkInput()) {
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
                url: 'http://localhost:3000/api/bridgeTypeCpn/add',
                method: "POST",
                params: {
                    type_no: type_no,
                    bri_cpn_no: bri_cpn_no.value,
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

        const onUpdate = (record: any) => {
            bri_cpn_no.value = record.bri_cpn_no
            old_bri_cpn_no.value = record.bri_cpn_no
            visible.value = true
            isUpdate.value = true
        }

        const handleUpdate = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeTypeCpn/update',
                method: "POST",
                params: {
                    old_bri_cpn_no: old_bri_cpn_no.value,
                    new_bri_cpn_no: bri_cpn_no.value,
                    type_no: type_no,
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

        const onDelete = (type_no: any,bri_cpn_no: any) => {
            axios({
                url: 'http://localhost:3000/api/bridgeTypeCpn/delete',
                method: "POST",
                params: {
                    type_no: type_no,
                    bri_cpn_no: bri_cpn_no,
                }
            }).then((resp) => {
                error_message(resp.data.error_info, resp.data.error_info)
                getTypeCpns()
            })
        }

        return {
            components,
            columns,
            dataSource,
            type_no,
            bri_cpn_no,
            handleOk,
            visible,
            onUpdate,
            onDelete,
            cleanInput,
        };
    },
});
</script>

<style>
.ant-card-body {
    display: flex;
    align-items: center;
    padding: 0;
}

.head-card {
    padding: 0;
    margin-bottom: 1em;
}

.head-title {
    text-align: center;
    flex: 1;
    margin: 0;
    font-size: 1.3em;
    font-weight: bolder;
    height: 5em;
    line-height: 5em;
}
.input-cpn {
    margin: .5em;
    height: 2.5em;
}
</style>

