<template>
    <div class="base-box">
        <a-row>
            <a-col :span="16">
                <a-card hoverable class="left-info-box">
                    <div class="info-grid">
                        <img class="info-avator" src="../../assets/images/avator.png" alt="avator" />
                        <div class="user-info">
                            <h3>姓名：{{ userStore.username }}</h3>
                            <h3>桥梁记录工程师</h3>
                        </div>
                        <h3>单位：{{ userStore.unit_name }}</h3>
                    </div>
                </a-card>
            </a-col>
            <a-col :span="8">
                <a-card hoverable class="right-info-box">
                    <h2>广告位招租</h2>
                </a-card>
            </a-col>
        </a-row>
        
        <a-row>
            <a-col :span="24">
                <div class="chat-box">
                    <a-card hoverable class="chat-card">
                        <h2>广告位招租</h2>
                    </a-card>
                </div>
            </a-col>
            
        </a-row>
        
    </div>
    
</template>

<script lang="ts">
import { SettingOutlined, EditOutlined, EllipsisOutlined } from '@ant-design/icons-vue';
import { defineComponent } from 'vue';
import { useUserStore } from '../../store/user';
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
    height: 15em;
    margin: .5em;
    padding: 0;
    align-items: center;
    justify-content: space-between;
}

.right-info-box {
    height: 15em;
    margin: 0.5em;
}

.chat-card {
    margin: .5em;
    height: 35em;
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



</style>