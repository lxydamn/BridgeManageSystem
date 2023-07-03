<template>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 12 }" style="height: 80vh;">
        <template #bodyCell="{ column, record }">
            <template v-if="column.dataIndex === 'operation'">
                <a-popconfirm v-if="dataSource.length" title="确认要删除吗？" ok-text="确认" cancel-text="取消"
                    @confirm="onDelete(record.stru_rcd_no)">
                    <a>删除</a>
                </a-popconfirm>
            </template>
        </template>
    </a-table>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, ref } from 'vue';
import { error_message } from "../../utils/errorMessage.ts"
import {useUserStore} from "../../store/user.ts";
const columns = [
    {
        title: "桥梁编号",
        dataIndex: 'bridge_no',
        ellipsis: true,
    },
    {
        title: "部位",
        dataIndex: 'bri_part_name',
        ellipsis: true,
    },
    {
        title: '部件名称',
        dataIndex: 'cet_part_name',
        ellipsis: true,
    },
    {
        title: '评分',
        dataIndex: 'score',
        ellipsis: true,
    },
    {
        title: '缺损类型',
        dataIndex: 'dft_type',
        ellipsis: true,
    },
    {
        title: '缺损位置',
        dataIndex: 'dft_position',
        ellipsis: true,
    },
    {
        title: '缺损范围',
        dataIndex: 'dft_range',
        ellipsis: true,
    },
    {
        title: '缺损照片',
        dataIndex: 'dft_photo',
        ellipsis: true,
    },
    {
        title: '缺损最不利构件',
        dataIndex: 'dft_most_part',
        ellipsis: true,
    },
    {
        title: '养护建议',
        dataIndex: 'mte_suggest',
        ellipsis: true,
    },
    {
        title: '是否需特殊检查',
        dataIndex: 'spc_inspect',
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },

];

interface StructRecord {
    bridge_no: string
    stru_rcd_no: string
    bri_part_name:string
    cet_part_name: string
    score: string
    dft_type: string
    dft_position: string
    dft_range: string
    dft_photo: string
    dft_most_part: string
    mte_suggest: string
    spc_inspect: string
}
export default defineComponent({
    components: {

    },
    setup() {
        const dataSource: Ref<StructRecord[]> = ref([])
        const userStore = useUserStore()

        const getStructRecord = () => {
            axios({
                url: 'http://localhost:3000/api/periCard/get/structRecord2',
                method: 'GET',
                params: {
                    unit_no: userStore.unit_no,
                }
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getStructRecord()


        const onDelete = (stru_rcd_no: any) => {
            axios({
                url: 'http://localhost:3000/api/periCard/delete/structRecord',
                method: "POST",
                params: {
                    stru_rcd_no: stru_rcd_no,
                }
            }).then((resp) => {
                error_message(resp.data.error_info, resp.data.error_info)
                getStructRecord()
            })
        }

        return {
            columns,
            dataSource,
            onDelete,
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
  
  