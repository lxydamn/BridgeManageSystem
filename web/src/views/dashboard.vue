<template>
    <div class="base-info-box">
        <a-card hoverable class="left-info-box">
            <div class="info-grid">
                <img class="info-avator" src="../assets/images/avator.png" alt="avator" />
                <div class="user-info">
                    <h3>姓名：{{ userStore.username }}</h3>
                    <h3>桥梁记录工程师</h3>
                </div>
                <h3>单位：{{ userStore.unit_name }}</h3>
            </div>
        </a-card>
        <a-card hoverable class="right-info-box">
            <h2>广告位招租</h2>
        </a-card>
    </div>
</template>

<script lang="ts">
import { SettingOutlined, EditOutlined, EllipsisOutlined } from '@ant-design/icons-vue';
import { defineComponent } from 'vue';
import { useUserStore } from '../store/user';
export default defineComponent({
    components: {
        SettingOutlined,
        EditOutlined,
        EllipsisOutlined,
    },
    setup() {
        const userStore = useUserStore()
        return {
            userStore,
        }
    }

});
</script>

<style scoped>
.left-info-box {
    display: flex;
    margin-left: 2em;
    margin-right: 3em;
    height: 15em;
    align-items: center;
    justify-content: space-between;
}

.info-grid {
    display: flex;
    width: 40vw;
    justify-content: space-between;
}

.user-info {
    margin-left: 3rem;
    width: 30%;
}

.info-avator {
    width: 15%;
    height: 15%;
    border-radius: 50%;
    padding: 0.3em;
    box-shadow: inset 0 0 10px #000;
    transition: all .8s;
}

.info-avator:hover {
    transform: rotate(180deg);
}

.right-info-box {
    width: 30%;
}

.base-info-box {
    display: flex;
    margin-left: 3rem;
}
</style>