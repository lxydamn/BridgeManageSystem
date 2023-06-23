<template>
    <div class="base-box">
        <a-row>
            <a-col :span="16">
                <a-card class="data-board">
                    <a-card-grid class="data-item" >
                        <a-statistic title="管理桥梁" suffix="座" :value="bridgeCount.arr.bridgeCount" />
                    </a-card-grid>
                    <a-card-grid class="data-item" >
                        <a-statistic title="已完成基本卡片" suffix="座" :value="bridgeCount.arr.basicCardCount" />
                    </a-card-grid>
                    <a-card-grid class="data-item" >
                        <a-statistic title="已完成初始检查" suffix="座" :value="bridgeCount.arr.initRecordCount" />
                    </a-card-grid>
                    <a-card-grid class="data-item" >
                        <a-statistic title="已完成定期检查" suffix="座" :value="bridgeCount.arr.periRecordCount" />
                    </a-card-grid>
                </a-card>
            </a-col>
            <a-col :span="8">
                <a-card hoverable class="right-info-box">
                    <div class="info-grid">
                        <img class="info-avator" src="../../assets/images/avator.png" alt="avator" />
                        <div class="user-info">
                            <p>姓名：{{ userStore.username }}</p>
                            <p>桥梁记录工程师</p>
                            <p>单位：{{ userStore.unit_name }}</p>
                        </div>
                    </div>
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
import { defineComponent, reactive } from 'vue';
import { useUserStore } from '../../store/user';
import axios from 'axios';
export default defineComponent({
    components: {
        SettingOutlined,
        EditOutlined,
        EllipsisOutlined,
    },
    setup() {
        const userStore = useUserStore()
        let bridgeCount = reactive({
            arr: {
                bridgeCount: 0,
                basicCardCount: 0,
                initRecordCount: 0,
                periRecordCount: 0,
            }    
        })

        const getCount = () => {
            axios({
                url: 'http://localhost:3000/api/bridge/unit/count',
                method:'GET',
                params: {
                    unit_no:userStore.unit_no,
                }
            }).then((resp) => {
                bridgeCount.arr = resp.data
            })
        }
        getCount()

        return {
            userStore,
            bridgeCount,
        }
    }

});
</script>

<style scoped>

.data-item {
    width: 25%;
    height: 10em;
    text-align: center;
    line-height: 10em;
    transition: .5s all;
}

.data-board {
    height: 10em;
    margin-right: 1em;
}
.right-info-box {
    height: 10em;
}

.right-info-box .ant-card-body {
    margin: 0;
    padding:0;
}

.chat-card {
    margin-top: 1em;
    height: 35em;
}

.info-grid {
    display: flex;
    justify-content: space-around;
}

.user-info {
    margin-left: 1rem;
}

.info-avator {
    height: 20%;
    width: 20%;
    border-radius: 50%;
    padding: 0.3em;
    box-shadow: inset 0 0 10px #000;
    transition: all .8s;
}

.info-avator:hover {
    transform: rotate(180deg);
}

</style>