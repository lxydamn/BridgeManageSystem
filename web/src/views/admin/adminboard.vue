<template>
    <a-row>
        <a-col :span="16">
            <a-card
                class="left-board"
                :loading="loading.type"
                title="桥梁类型统计"
                hoverable
            >
                <div class="statistic-count-box">
                    <a-statistic v-for="item in typeCount.data"
                         class="statistic-item"
                         suffix="座"
                         :title=item.type_name
                         :value=item.type_count
                    />
                </div>

            </a-card>

            <a-card
                class="left-board"
                :loading="loading.card"
                title="初始信息录入情况"
                hoverable
            >
                <div class="statistic-count-box">
                    <a-statistic
                        class="statistic-item"
                        suffix="座"
                        title="桥梁数量"
                        :value=cardCount.data.bridge_count
                    />
                    <a-statistic
                        class="statistic-item"
                        suffix="个"
                        title="基本状况卡片"
                        :value=cardCount.data.basic_count
                    />
                    <a-statistic
                        class="statistic-item"
                        suffix="个"
                        title="初始检查卡片"
                        :value=cardCount.data.init_count
                    />
                    <a-statistic
                        class="statistic-item"
                        suffix="个"
                        title="定期检查卡片"
                        :value=cardCount.data.peri_count
                    />
                </div>

            </a-card>
        </a-col>
        <a-col :span="8">

            <a-card
                :loading="loading.user"
                title="用户单位统计"
                hoverable
            >
                <div class="statistic-count-box">
                    <a-statistic
                        class="statistic-item"
                        suffix="个"
                        title="用户"
                        :value="uuCount.data.user_count"
                    />
                    <a-statistic
                        class="statistic-item"
                        suffix="个"
                        title="单位"
                        :value="uuCount.data.unit_count"
                    />
                </div>
            </a-card>

            <a-card
                :loading="loading"
                title="用户单位统计"
                hoverable
                style="margin-top: 3em"
            >
                <div class="user-unit-statistic">
                    <a-statistic class="statistic-item" suffix="个" title="单位" :value="1128" />
                    <a-statistic class="statistic-item" suffix="个" title="用户" :value="1128" />
                </div>
            </a-card>
        </a-col>
    </a-row>
</template>

<script lang="ts">
import {defineComponent, reactive, ref} from 'vue';
import axios from "axios";

export default defineComponent({
    components:{
        
    },
    setup() {
        const loading = reactive({
            type:true,
            card:true,
            user:true,

        })

        const typeCount = reactive({
            data:[]
        })

        const cardCount = reactive({
            data:[],
        })
        const uuCount = reactive({
            data:[],
        })


        const getTypeCount = () => {
            axios({
                url:'http://localhost:3000/api/bridgeType/count',
                method:"GET",
            }).then((resp) => {
                typeCount.data = resp.data
                loading.type = false;
            })
        }
        getTypeCount()

        const getUUCount = () => {
            axios({
                url:'http://localhost:3000/api/uu/count',
                method:"GET",
            }).then((resp) => {
                uuCount.data = resp.data
                loading.user = false;
            })
        }
        getUUCount()

        const getCardCount = () => {
            axios({
                url:'http://localhost:3000/api/card/count',
                method:"GET",
            }).then((resp) => {
                cardCount.data = resp.data
                console.log(cardCount.data)
                loading.card= false;
            })
        }
        getCardCount()

        return {
            loading,
            typeCount,
            cardCount,
            uuCount,
        }
    }
})
</script>

<style>

.user-unit-statistic {
    display: flex;
    justify-content: space-around;
    width: 100%;
}
.left-board {
    margin-right: 1em;
}
.statistic-item {
    flex-grow: 1;
    text-align: center;
    transition: .6s all;
    border-left: 1px solid #6c6969;
}
.statistic-item:first-child {
    border: none;
}
.statistic-item:hover {
    flex-grow: 2;
}
.statistic-count-box {
    display: flex;
    transition: .6s all;
}
.left-board {
    margin-bottom: 3em;
}
.right-statistic {
    width: 33%;
    text-align: center;
}

</style>