<template>
    <div>
        <a-menu v-model:selectedKeys="selectedKeys" mode="inline" style="
          height: 90vh;
        " @click="clickRouter" :open-keys="openKeys" @openChange="onOpenChange">
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
            <a-sub-menu key="bridge">
                <template #icon>
                    <FileDoneOutlined />
                </template>
                <template #title>信息录入</template>
                <a-menu-item key="1">桥梁基本卡片</a-menu-item>
                <a-menu-item key="2">初始检查记录</a-menu-item>
                <a-menu-item key="3">定期检查记录</a-menu-item>
            </a-sub-menu>
            <a-menu-item key="part">
                <template #icon>
                    <ApartmentOutlined />
                </template>
                部件配置
            </a-menu-item>
        </a-menu>

    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue';
import {
    MailOutlined, DatabaseOutlined, FileDoneOutlined,
    ApartmentOutlined, AppstoreOutlined, SettingOutlined
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
    },
    setup() {
        const state = reactive({
            rootSubmenuKeys: ['sub1', 'sub2', 'sub4'],
            openKeys: ['sub1'],
            selectedKeys: [],
        });

        const clickRouter = (item: any) => {
            router.push(item.key)
        }

        const onOpenChange = (openKeys: string[]) => {
            const latestOpenKey = openKeys.find(key => state.openKeys.indexOf(key) === -1);
            if (state.rootSubmenuKeys.indexOf(latestOpenKey!) === -1) {
                state.openKeys = openKeys;
            } else {
                state.openKeys = latestOpenKey ? [latestOpenKey] : [];
            }
        };
        return {
            ...toRefs(state),
            clickRouter,
            onOpenChange,
        };
    },
});
</script>
  
  