<template>
    <div>
        <a-menu v-model:selectedKeys="selectedKeys" mode="inline" style="
          height: 90vh;
        " @click="clickRouter" :open-keys="openKeys" @openChange="onOpenChange">
            <a-menu-item key="dashboard">
                <template #icon>
                    <AppstoreOutlined />
                </template>
                信息统计
            </a-menu-item>
            <a-menu-item key="user">
                <template #icon>
                    <DatabaseOutlined />
                </template>
                用户管理
            </a-menu-item>
            <a-menu-item key="unit">
                <template #icon>
                    <ApartmentOutlined />
                </template>
                单位管理
            </a-menu-item>
            <a-menu-item key="route">
                <template #icon>
                    <RiseOutlined />
                </template>
                路线管理
            </a-menu-item>
            <a-sub-menu key="bridge">
                <template #icon>
                    <FileDoneOutlined />
                </template>
                <template #title>桥梁管理</template>
                <a-menu-item key="type">桥梁类型管理</a-menu-item>
                <a-menu-item key="part">桥梁部位管理</a-menu-item>
                <a-menu-item key="component">桥梁部件管理</a-menu-item>
                <a-menu-item key="typeComponent">桥梁桥梁类型部件配置</a-menu-item>
            </a-sub-menu>
        </a-menu>

    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue';
import {
    MailOutlined, DatabaseOutlined, FileDoneOutlined,
    ApartmentOutlined, AppstoreOutlined, SettingOutlined,
    RiseOutlined,
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
        RiseOutlined,
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
  
  