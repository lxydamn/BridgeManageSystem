<template>
    <a-button class="operator-btn" @click="visible = true">添加桥梁部位</a-button>

    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 68vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a style="margin-right: .5em;" @click="onUpdate(record)">修改</a>
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.bri_part_no)"
                >
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="桥梁部位"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
        @cancel="cleanInput"
    >
        <a-input
            class="input-cpn"
            pattern="[0-9]*"
            v-model:value="modalValue.bri_part_no"
            placeholder="桥梁部位编号"
        />
        <a-input
            class="input-cpn"
            v-model:value="modalValue.bri_part_name"
            placeholder="桥梁部位名称"
        />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import { error_message } from '../../utils/errorMessage';

const columns = [
    {
        title: "部位编号",
        dataIndex: 'bri_part_no',
    },
    {
        title: '部位名称',
        dataIndex: 'bri_part_name',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },

];

interface BridgePart {
    bri_part_no:string
    bri_part_name: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        let isUpdate = ref(false)
        let old_bri_part_no = ref("")
        const dataSource: Ref<BridgePart[]> = ref([])

        let units = ref([])

        const checkInput = () => {
            if (modalValue.bri_part_no.length == 0 || modalValue.bri_part_name.length == 0 )
                return false
            return true
        }

        const cleanInput = () => {
            visible.value = false
            isUpdate.value = false

            modalValue.bri_part_no = ""
            modalValue.bri_part_name =""
            old_bri_part_no.value=""

            getParts()
        }

        const modalValue = reactive({
            bri_part_no:'',
            bri_part_name:'',
        })

        const getParts = () => {
            axios({
                url: 'http://localhost:3000/api/bridgePart/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getParts()

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
                url:'http://localhost:3000/api/bridgePart/add',
                method:"POST",
                params:{
                    bri_part_no: modalValue.bri_part_no,
                    bri_part_name: modalValue.bri_part_name,
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
            modalValue.bri_part_no = record.bri_part_no
            modalValue.bri_part_name = record.bri_part_name
            old_bri_part_no.value = record.bri_part_no
            visible.value = true
            isUpdate.value = true
        }

        const handleUpdate = () => {
            axios({
                url:'http://localhost:3000/api/bridgePart/update',
                method:"POST",
                params:{
                    old_bri_part_no:old_bri_part_no.value,
                    new_bri_part_no:modalValue.bri_part_no,
                    bri_part_name:modalValue.bri_part_name,
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

        const onDelete = (bri_part_no : any) => {
            axios({
                url:'http://localhost:3000/api/bridgePart/delete',
                method:"POST",
                params: {
                    bri_part_no: bri_part_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getParts()
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

