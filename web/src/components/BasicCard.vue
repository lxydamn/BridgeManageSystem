<template>
    <a-skeleton :loading="loading" active>
        <div class="basic-card-container" v-if="!loading">
            <a-form layout="horizontal" class="basic-card-form">
                <h3>行政识别数据</h3>
                <hr>
                <a-form-item >
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name" style="width: 15%" >桥梁所属行政区代码</td>
                            <td class="table-item-content">
                                <a-input peace-holder="请输入" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>行政识别数据</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁技术指标</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁结构信息</h3>
                <hr>
                <a-form-item>
                    <div class="struct-container" v-for="item in bridgeStruct.arr">
                        <a-row>
                            <a-col :span="1" class="struct-main"> <h4> {{item.struct}} </h4></a-col>
                            <a-col :span="23">
                                <table class="sub-struct-table" >
                                    <tr v-for="subItem in item.subStruct">
                                        <td style="width: 10%;"> {{ subItem.subName }} </td>
                                        <td v-for="data in subItem.subArr">{{ data }}</td>
                                    </tr>
                                </table>
                            </a-col>
                        </a-row>
                        <hr>
                    </div>
                </a-form-item>
                <h3>桥梁档案资料</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁检测评定历史（动态）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>养护处治记录（加标题）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>说明事项（文本框）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>其他（参照卡片）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
            </a-form>
        </div>
    </a-skeleton>
    <div class="footer-bar" v-if="!loading">
        <a-button type="primary">P</a-button>
    </div>

</template>

<script lang="ts">
import {defineComponent, reactive, ref} from 'vue';

export default defineComponent({
    components: {

    },
    setup() {
        let loading = ref(true)

        const bridgeStruct = reactive({
            arr: [
                {
                    struct: "主结构",
                    subStruct: [
                        {
                            subName:"主梁",
                            subArr: [1, 2, 3, 4, 5],
                        },
                        {
                            subName:"主梁1",
                            subArr: [1, 2, 3, 4, 5],
                        },
                        {
                            subName:"主梁2",
                            subArr: [1, 2, 3, 4, 5],
                        }
                    ]
                },
                {
                    struct: "上下结构",
                    subStruct: [
                        {
                            subName:"主拱圈",
                            subArr: [1, 2, 3, 4],
                        }
                    ]
                }
            ]
        })
        const init = () => {
            setTimeout(() => {
                loading.value = false
            }, 1000)
        }
        init()
        return {
            loading,
            bridgeStruct,
        }
    }
})

</script>

<style scoped>
.basic-card-container {
    overflow: hidden auto;
    width: 95%;
}
.footer-bar {
    background-color: #FFF;
    position: absolute;
    top: 11vh;
    right: 2%;
}
.sub-struct-table {
    width: 100%;
    text-align: center;
    border-collapse: separate;
    border-spacing: .5em .5em;
}
.struct-main {
    writing-mode: vertical-rl;
    text-align: center;
    padding: .5em;
    display: flex;
    justify-content: center;
    border-right: 1px solid #bebdbd;
    align-items: center;
}
.basic-card-form {
    padding: 1em;
    border-radius: .3em;
    background-color: #FFF;
    box-shadow: none;
}
.basic-card-table {
    border-collapse: separate;
    border-spacing: .5em .5em;
    width: 100%;
}
.table-item-name {
    width: 6%;
    text-align: center;
}
.basic-card-table~tr {
    margin-bottom: 1em;
}
hr {
    margin: 0;
}
h3 {
    margin-bottom: .8em;
}
</style><template>
    <a-skeleton :loading="loading" active>
        <div class="basic-card-container" v-if="!loading">
            <a-form layout="horizontal" class="basic-card-form">
                <h3>行政识别数据</h3>
                <hr>
                <a-form-item >
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name" style="width: 15%" >桥梁所属行政区代码</td>
                            <td class="table-item-content">
                                <a-input peace-holder="请输入" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>行政识别数据</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁技术指标</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁结构信息</h3>
                <hr>
                <a-form-item>
                    <div class="struct-container" v-for="item in bridgeStruct.arr">
                        <a-row>
                            <a-col :span="1" class="struct-main"> <h4> {{item.struct}} </h4></a-col>
                            <a-col :span="23">
                                <table class="sub-struct-table" >
                                    <tr v-for="subItem in item.subStruct">
                                        <td style="width: 10%;"> {{ subItem.subName }} </td>
                                        <td v-for="data in subItem.subArr">{{ data }}</td>
                                    </tr>
                                </table>
                            </a-col>
                        </a-row>
                        <hr>
                    </div>
                </a-form-item>
                <h3>桥梁档案资料</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>桥梁检测评定历史（动态）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>养护处治记录（加标题）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>说明事项（文本框）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
                <h3>其他（参照卡片）</h3>
                <hr>
                <a-form-item>
                    <table class="basic-card-table">
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-item-name">路线编号</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线名称</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                            <td class="table-item-name">路线等级</td>
                            <td class="table-item-content">
                                <a-input peace-holder="路线编号" />
                            </td>
                        </tr>
                    </table>
                </a-form-item>
            </a-form>
        </div>
    </a-skeleton>
    <div class="footer-bar" v-if="!loading">
        <a-button type="primary">P</a-button>
    </div>

</template>

<script lang="ts">
import {defineComponent, reactive, ref} from 'vue';

export default defineComponent({
    components: {

    },
    setup() {
        let loading = ref(true)

        const bridgeStruct = reactive({
            arr: [
                {
                    struct: "主结构",
                    subStruct: [
                        {
                            subName:"主梁",
                            subArr: [1, 2, 3, 4, 5],
                        },
                        {
                            subName:"主梁1",
                            subArr: [1, 2, 3, 4, 5],
                        },
                        {
                            subName:"主梁2",
                            subArr: [1, 2, 3, 4, 5],
                        }
                    ]
                },
                {
                    struct: "上下结构",
                    subStruct: [
                        {
                            subName:"主拱圈",
                            subArr: [1, 2, 3, 4],
                        }
                    ]
                }
            ]
        })
        const init = () => {
            setTimeout(() => {
                loading.value = false
            }, 1000)
        }
        init()
        return {
            loading,
            bridgeStruct,
        }
    }
})

</script>

<style scoped>
.basic-card-container {
    overflow: hidden auto;
    width: 95%;
}
.footer-bar {
    background-color: #FFF;
    position: absolute;
    top: 11vh;
    right: 2%;
}
.sub-struct-table {
    width: 100%;
    text-align: center;
    border-collapse: separate;
    border-spacing: .5em .5em;
}
.struct-main {
    writing-mode: vertical-rl;
    text-align: center;
    padding: .5em;
    display: flex;
    justify-content: center;
    border-right: 1px solid #bebdbd;
    align-items: center;
}
.basic-card-form {
    padding: 1em;
    border-radius: .3em;
    background-color: #FFF;
    box-shadow: none;
}
.basic-card-table {
    border-collapse: separate;
    border-spacing: .5em .5em;
    width: 100%;
}
.table-item-name {
    width: 6%;
    text-align: center;
}
.basic-card-table~tr {
    margin-bottom: 1em;
}
hr {
    margin: 0;
}
h3 {
    margin-bottom: .8em;
}
</style>