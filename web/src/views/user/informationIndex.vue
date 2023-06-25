<template>
    <a-table :columns="columns" :data-source="dataSource" :pagination="{ pageSize: 8}" style="height: 80vh">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'tags'">
                <span>
                  <a-tag
                      :color="record.basic == 'finish' ? 'green' : 'volcano' "
                  >
                    <template #icon>
                      <CheckCircleOutlined v-if="record.basic === 'finish' "/>
                      <CloseCircleOutlined v-if="record.basic === 'unfinished' "/>
                    </template>
                    <router-link :to="{name:'basicCard', query:{bridge_no:record.bridge_no, status:record.basic, initStatus:record.init}}">
                        基本卡片
                    </router-link>
                  </a-tag>

                  <a-tag
                      :color="record.init === 'finish' ? 'green' : 'volcano' "
                  >
                    <template #icon>
                      <CheckCircleOutlined v-if="record.init === 'finish' "/>
                      <CloseCircleOutlined v-if="record.init === 'unfinished' "/>
                    </template>
                    <router-link :to="{name:'initCard', query:{bridge_no:record.bridge_no, status:record.init }}">
                        初始检查
                    </router-link>
                  </a-tag>
                  <a-tag
                      :color="record.peri == 'finish' ? 'green' : 'volcano' "
                  >
                    <template #icon>
                      <CheckCircleOutlined v-if="record.peri === 'finish' "/>
                      <CloseCircleOutlined v-if="record.peri === 'unfinished' "/>
                    </template>
                    <router-link :to="{name:'periCard', query:{bridge_no:record.bridge_no, status:record.peri }}">
                        定期检查
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
      CheckCircleOutlined,
      CloseCircleOutlined,
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