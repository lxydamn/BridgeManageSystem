<template>
    <a-table :columns="columns" :data-source="dataSource">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'tags'">
                <span>
                  <a-tag
                          :color="record.basic == 'finish' ? 'green' : 'volcano' "
                  >
                    <router-link :to="{name:'basicCard', query:{bridge_no:record.bridge_no}}">
                        基本卡片
                    </router-link>
                  </a-tag>

                  <a-tag
                          :color="record.peri == 'finish' ? 'green' : 'volcano' "
                  >
                    定期检查
                  </a-tag>
                  <a-tag
                          :color="record.init == 'finish' ? 'green' : 'volcano' "
                  >
                    初始检查
                  </a-tag>
                </span>
            </template>
        </template>
    </a-table>
</template>

<script lang="ts">

import {defineComponent, ref, Ref} from "vue";
import axios from "axios";
import {useUserStore} from "../../store/user.ts";

const columns = [
    {
        title: '桥梁编号',
        dataIndex: 'bridge_no',
        ellipsis: true,
    },
    {
        title: '桥梁名称',
        dataIndex: 'bridge_name',
        ellipsis: true,
    },
    {
        title: '初始检查完成情况',
        dataIndex: 'tags',
        ellipsis: true,
    },

];

interface BridgeCardInfo {
    bridge_no:string
    bridge_name:string
    basic:string
    peri:string
    init:string
}
export default defineComponent ({
    components: {

    },
    setup() {

        const userStore = useUserStore();

        let dataSource: Ref<BridgeCardInfo[]> = ref([])


        const getData = () => {
            axios({
                url:'http://localhost:3000/api/bridge/card/status',
                method:"GET",
                params:{
                    unit_no: userStore.unit_no,
                }
            }).then((resp) => {
                console.log(resp.data)
                dataSource.value = resp.data
            })
        }

        getData()

        return {
            dataSource,
            columns,
        }
    }
})

</script>

<style>
</style>