<template>
    <a-card class="head-card">
        <p class="head-title">你当前正在为{{ $route.query.bridge_name }}配置桥梁部件</p>
        <a-button type="primary" shape="circle" size="large" @click="visible = true">
            <template #icon><PlusOutlined /> </template>
        </a-button>
    </a-card>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8 }" style="height: 69vh">
        <template #bodyCell="{ column, record }">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm v-if="dataSource.length" title="确认要删除吗？" ok-text="确认" cancel-text="取消"
                    @confirm="onDelete(record.cet_part_no)">
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>

    <a-modal v-model:visible="visible" title="桥梁具体部件" ok-text="确认" cancel-text="取消" @ok="handleOk" @cancel="cleanInput">
        <a-input class="input-cpn" 
            pattern="[0-9]*" 
            v-model:value="modalValue.cet_part_no" 
            placeholder="具体部件编号" />
        <a-input 
            class="input-cpn" 
            v-model:value="modalValue.cet_part_name" 
            placeholder="具体部件名称" />
        <p class="tip">桥梁部件:</p>
        <a-select 
            class="input-cpn" 
            ref="select" 
            v-model:value="modalValue.bri_cpn_no" 
            style="width: 100%;"
            :options="typeCpn" 
            :field-names="{ label: 'bri_cpn_name', value: 'bri_cpn_no' }" />
        <a-input 
            class="input-cpn" 
            v-model:value="modalValue.material" 
            placeholder="具体部件材料" />
        <a-input 
            class="input-cpn" 
            v-model:value="modalValue.format" 
            placeholder="具体部件形式" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue'
import { error_message } from '../../utils/errorMessage';
import { useRoute } from "vue-router";
const columns = [
    {
        title: "具体部件编码",
        dataIndex: 'cet_part_no',
    },
    {
        title: "具体部件名称",
        dataIndex: 'cet_part_name',
        ellipsis: true,
    },
    {
        title: "桥梁名称",
        dataIndex: 'bridge_name',
        ellipsis: true,
    },
    {
        title: "类型名称",
        dataIndex: 'type_name',
        ellipsis: true,
    },
    {
        title: "桥梁部件名称",
        dataIndex: 'bri_cpn_name',
        ellipsis: true,
    },
    {
        title: "桥梁部件材料",
        dataIndex: 'material',
        ellipsis: true,
    },
    {
        title: "桥梁部件形式",
        dataIndex: 'format',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
];

interface BridgeCepPart {
    cet_part_no: string
    cet_part_name: string
    bridge_no: string
    bridge_name: string
    type_name: string
    bri_cpn_no: string
    bri_cpn_name: string
    material: string
    format: string
}

export default defineComponent({
    components: {
        PlusOutlined,
    },

    setup() {
        const route = useRoute();
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_cet_part_no = ref("")
        const dataSource: Ref<BridgeCepPart[]> = ref([])
        let typeCpn = ref([])

        const getTypeCpns = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeTypeCpn/get/all',
                method: 'GET',
                params: {
                    type_no: route.query.type_no
                }
            }).then((resp) => {
                console.log(resp.data)
                typeCpn.value = resp.data
            })
        }
        getTypeCpns()


        const checkInput = () => {
            if (modalValue.cet_part_no.length == 0 || modalValue.cet_part_name === '' || modalValue.bri_cpn_no === ''
                || modalValue.material === '' || modalValue.format === '')
                return false
            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.cet_part_no = ""
            modalValue.cet_part_name = ""
            modalValue.bri_cpn_no = ""
            modalValue.material = ""
            modalValue.format = ""
            old_cet_part_no.value = ""
            getCetParts()
        }
        

        const modalValue = reactive({
            cet_part_no: '',
            cet_part_name: '',
            bri_cpn_no: '',
            material: '',
            format: '',
        })

        const getCetParts = () => {
            axios({
                url: 'http://localhost:3000/api/cetPart/get',
                method: 'GET',
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getCetParts()

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
                url: 'http://localhost:3000/api/cetPart/add',
                method: "POST",
                params: {
                    cet_part_no: modalValue.cet_part_no,
                    bridge_no: route.query.bridge_no,
                    type_no: route.query.type_no,
                    bri_cpn_no: modalValue.bri_cpn_no,
                    cet_part_name: modalValue.cet_part_name,
                    material: modalValue.material,
                    format: modalValue.format
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
            modalValue.cet_part_no = record.cet_part_no
            modalValue.bri_cpn_no = record.bri_cpn_no
            modalValue.cet_part_name = record.cet_part_name
            modalValue.material = record.material
            modalValue.format = record.format
            old_cet_part_no.value = record.cet_part_no
            visible.value = true
            isUpdate.value = true
        }

        const handleUpdate = () => {
            axios({
                url: 'http://localhost:3000/api/cetPart/update',
                method: "POST",
                params: {
                    new_cet_part_no: modalValue.cet_part_no,
                    bridge_no: route.query.bridge_no,
                    type_no: route.query.type_no,
                    bri_cpn_no: modalValue.bri_cpn_no,
                    cet_part_name: modalValue.cet_part_name,
                    old_cet_part_no: old_cet_part_no.value,
                    material: modalValue.material,
                    format: modalValue.format
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

        const onDelete = (cet_part_no: any) => {
            axios({
                url: 'http://localhost:3000/api/cetPart/delete',
                method: "POST",
                params: {
                    cet_part_no: cet_part_no
                }
            }).then((resp) => {
                error_message(resp.data.error_info, resp.data.error_info)
                getCetParts()
            })
        }

        return {
            typeCpn,
            columns,
            dataSource,
            modalValue,
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
.tip {
    margin: 0.5em;
    margin-top: 1em;
    padding: 0;
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

