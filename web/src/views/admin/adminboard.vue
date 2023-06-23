<template>
    <a-row>
        <a-col :span="16">
            <a-card
                class="left-board"
                :loading="loading"
                title="Card title"
                hoverable
            >
                whatever content
            </a-card>
        </a-col>
        <a-col :span="8">

            <a-card
                :loading="loading"
                title="用户单位统计"
                hoverable
            >
                <div class="user-unit-statistic">
                    <a-statistic class="statistic-item" suffix="个" title="单位" :value="1128" />
                    <a-statistic class="statistic-item" suffix="个" title="用户" :value="1128" />
                </div>
            </a-card>

            <a-card
                :loading="loading"
                title="用户单位统计"
                hoverable
                style="margin-top: 10em"
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
import {defineComponent, ref} from 'vue';

export default defineComponent({
    components:{
        
    },
    setup() {
        const loading = ref(true)

        const init = () => {
            setTimeout(()=> {
                loading.value = false
            }, 1000)
        }
        init()
        return {
            loading,
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
    transition: .5s all;
}
.statistic-item:nth-child(odd) {
    border-right: 1px solid #6c6969;
}
.statistic-item:hover {
    flex-grow: 2;
}

</style>