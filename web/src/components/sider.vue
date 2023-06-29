<template>
    <div>
        <a-menu v-model:selectedKeys="selectedKeys" mode="inline" style="
          height: 90vh;
        " @click="clickRouter" >
            <a-menu-item key="dashboard">
                <template #icon>
                    <AppstoreOutlined />
                </template>
                首页
            </a-menu-item>
            <a-menu-item key="bridge">
                <template #icon>
                    <DatabaseOutlined />
                </template>
                桥梁管理
            </a-menu-item>
            <a-menu-item key="informationIndex">
                <template #icon>
                    <FileDoneOutlined />
                </template>
                信息录入
            </a-menu-item>
            <a-menu-item key="cpnConfigIndex">
                <template #icon>
                    <ApartmentOutlined />
                </template>
                部件配置
            </a-menu-item>
            <a-sub-menu key="bridge">
                <template #icon >
                    <DeleteOutlined />
                </template>
                <template #title>信息修改</template>
                <a-menu-item key="assessRecordIndex">
                    <template #icon >
                    <ScheduleOutlined />
                    </template>
                    检测历史记录
                </a-menu-item>
                <a-menu-item key="maintainRecordIndex">
                    <template #icon>
                    <WalletOutlined />
                    </template>
                    养护处治记录
                </a-menu-item>
                <a-menu-item key="structRecord">
                    <template #icon>
                    <BuildOutlined />
                    </template>
                    桥梁部位结构检查
                </a-menu-item>
                
            </a-sub-menu>
        </a-menu>

    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue';
import {
    MailOutlined, DatabaseOutlined, FileDoneOutlined,
    ApartmentOutlined, AppstoreOutlined, SettingOutlined,
    ScheduleOutlined,WalletOutlined, DeleteOutlined,
    BuildOutlined
} from '@ant-design/icons-vue';
import router from '../router';
export default defineComponent({
    components: {
        MailOutlined,
        ApartmentOutlined,
        DatabaseOutlined,
        AppstoreOutlined,
        SettingOutlined,
        FileDoneOutlined,
        ScheduleOutlined,
        WalletOutlined,
        DeleteOutlined,
        BuildOutlined
    },
    setup() {
        const state = reactive({
            selectedKeys: [],
        });

        const clickRouter = (item: any) => {
            router.push({name:item.key})
        }

        return {
            ...toRefs(state),
            clickRouter,
        };
    },
});
</script>