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

.
  
  