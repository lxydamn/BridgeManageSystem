<template>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 80vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'tags'">
                <span>
                  <a-tag
                          :color="record.cet_part == 'finish' ? 'green' : 'volcano' "
                  >
                  <template #icon>
                    <CheckCircleOutlined v-if="record.cet_part === 'finish' "/>
                    <CloseCircleOutlined v-if="record.cet_part === 'unfinished' "/>
                  </template>
                    <router-link :to="{name:'cpnConfig', query:{bridge_no:record.bridge_no, bridge_name:record.bridge_name, type_no:record.type_no}}">
                        桥梁配件配置
                    </router-link>
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
import {CheckCircleOutlined ,CloseCircleOutlined} from '@ant-design/icons-vue'
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
        title: '桥梁部件配置完成情况',
        dataIndex: 'tags',
        ellipsis: true,
    },

];

interface BridgeCardInfo {
    bridge_no:string
    bridge_name:string
    cet_part: string
    type_no: string
}
export default defineComponent ({
    components: {
        CheckCircleOutlined,
        CloseCircleOutlined
    },
    setup() {

        const userStore = useUserStore();

        let dataSource: Ref<BridgeCardInfo[]> = ref([])

        const getData = () => {
            axios({
                url:'http://localhost:3000/api/cetPart/status',
                method:"GET",
                params:{
                    unit_no: userStore.unit_no,
                }
            }).then((resp) => {
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