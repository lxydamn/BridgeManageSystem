<template>
    <a-button class="operator-btn" @click="visible = true">添加桥梁部件</a-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 68.5vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.bri_cpn_no)"
                >
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="桥梁部件"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            pattern="[0-9]*"
            v-model:value="modalValue.bri_cpn_no"
            placeholder="桥梁部件编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.bri_cpn_name"
            placeholder="桥梁部件名称"
        />
        <p class="tip">桥梁部位选择:</p>
        <a-select 
        class="input-cpn" 
        ref="select"
        v-model:value="modalValue.bri_part_no" 
        style="width: 100%;" 
        :options="parts" 
        :field-names="{label:'bri_part_name', value:'bri_part_no'}"
        />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';

const columns = [
    {
        title: "部件编号",
        dataIndex: 'bri_cpn_no',
    },
    {
        title: '部件名称',
        dataIndex: 'bri_cpn_name',
        ellipsis: true,
    },
    {
        title: "部位名称",
        dataIndex: 'bri_part_name',
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
];

interface BridgeComponent {
    bri_cpn_no: string
    bri_part_no: string
    bri_part_name: string
    bri_cpn_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_bri_cpn_no = ref("")
        const dataSource: Ref<BridgeComponent[]> = ref([])
        let parts = ref([])

        const getParts = () => {
            axios({
                url: 'http://localhost:3000/api/bridgePart/get/all',
                method: 'GET',
            }).then((resp) => {
                parts.value = resp.data
            })
        }
        getParts()

        const checkInput = () => {
            if (modalValue.bri_cpn_no.length == 0 || modalValue.bri_part_no.length == 0  || modalValue.bri_cpn_name.length == 0)
                return false
            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.bri_cpn_no = ""
            modalValue.bri_part_no =""
            modalValue.bri_cpn_name =""
            old_bri_cpn_no.value=""

            getComponents()
        }

        const modalValue = reactive({
            bri_cpn_no:'',
            bri_cpn_name:'',
            bri_part_no:'',
        })

        const getComponents = () => {
            axios({
                url: 'http://localhost:3000/api/bridgeComponent/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getComponents()

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
            console.log(modalValue.bri_cpn_no)
            console.log(modalValue.bri_part_no)
            console.log(modalValue.bri_cpn_name)
            axios({
                url:'http://localhost:3000/api/bridgeComponent/add',
                method:"POST",
                params:{
                    bri_cpn_no: modalValue.bri_cpn_no,
                    bri_part_no: modalValue.bri_part_no,
                    bri_cpn_name: modalValue.bri_cpn_name,
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
            modalValue.bri_cpn_no = record.bri_cpn_no
            modalValue.bri_part_no = record.bri_part_no
            modalValue.bri_cpn_name = record.bri_cpn_name
            old_bri_cpn_no.value = record.bri_cpn_no
            visible.value = true
            isUpdate.value = true
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bridgeComponent/update',
                method:"POST",
                params:{
                    old_bri_cpn_no: old_bri_cpn_no.value,
                    new_bri_cpn_no: modalValue.bri_cpn_no,
                    bri_part_no: modalValue.bri_part_no,
                    bri_cpn_name: modalValue.bri_cpn_name,
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

        const onDelete = (bri_cpn_no : any) => {
            axios({
                url:'http://localhost:3000/api/bridgeComponent/delete',
                method:"POST",
                params: {
                    bri_cpn_no: bri_cpn_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getComponents()
            })
        }

        return {
            parts,
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
.ant-table {
    min-height: 68.43vh !important;
}
.operator-btn {
    margin-bottom: .8em;
    height: 3em;
}
.input-cpn {
    margin: .5em;
    height: 2.5em;
}
</style>

