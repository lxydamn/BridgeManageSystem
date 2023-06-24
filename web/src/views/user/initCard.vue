<template>
    <div class="init-card">
        <div class="header-tips">
            你当前正在编写编号为{{ $route.query.bridge_no }}的桥梁初始检查记录表
        </div>
        <a-skeleton :loading="loading" active>
            <div class="init-card-container" v-if="!loading">
                <a-form layout="horizontal" class="init-card-form">
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table-item-name" style="width: 15%">公路管理机构名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=userStore.unit_name disabled placeholder="公路管理机构名称" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table-item-name">路线编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.route_no placeholder="路线编号" disabled/>
                                </td>
                                <td class="table-item-name">路线名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.route_name placeholder="路线名称" disabled/>
                                </td>
                                <td class="table-item-name">桥位桩号</td>
                                <td class="table-item-content">
                                    <a-input placeholder="桥位桩号" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.bridge_no placeholder="桥梁编号" disabled/>
                                </td>
                                <td class="table-item-name">桥梁名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.vridge_name placeholder="桥梁名称" disabled/>
                                </td>
                                <td class="table-item-name">被跨越道路(通道)名称</td>
                                <td class="table-item-content">
                                    <a-input placeholder="被跨越道路(通道)名称" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">被跨越道路(通道)桩号</td>
                                <td class="table-item-content">
                                    <a-input placeholder="被跨越道路(通道)桩号" />
                                </td>
                                <td class="table-item-name">桥梁全长(m)</td>
                                <td class="table-item-content">
                                    <a-input placeholder="桥梁全长(m)" />
                                </td>
                                <td class="table-item-name">最大跨径(m)</td>
                                <td class="table-item-content">
                                    <a-input placeholder="最大跨径(m)" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">上、下部结构形式</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="上、下部结构形式" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">桥梁分联及跨径组合</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="桥梁分联及跨径组合" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">桥梁施工方法</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="桥梁施工方法" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">新建桥梁在施工过程中的返工、维修或加固情况</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="新建桥梁在施工过程中的返工、维修或加固情况" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">加固改造后的桥梁，加固改造情况</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="加固改造后的桥梁，加固改造情况" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">档案资料不齐全的桥梁，维修加固情况</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="档案资料不齐全的桥梁，维修加固情况" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table3-item-name">设计单位名称</td>
                                <td class="table3-item-content">
                                    <a-select :options="options" style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">施工单位名称</td>
                                <td class="table3-item-content">
                                    <a-select :options="options" style="height: 2em;"></a-select>
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table3-item-name">管养单位名称</td>
                                <td class="table3-item-content">
                                    <a-select :options="options" style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">交工时间</td>
                                <td class="table3-item-content">
                                    <a-date-picker v-model:value="value1" style="height: 2em; width: 100%;"/>
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table3-item-name">初始检查</td>
                                <td class="table3-item-content">
                                    <a-date-picker v-model:value="value1" style="height: 2em; width: 100%;"/>
                                </td>
                                <td class="table3-item-name">初始检查时的气候及环境温度</td>
                                <td class="table3-item-content">
                                    <a-input placeholder="初始检查时的气候及环境温度" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">桥面高程</td>
                            <td class="table2-item-content">
                                <a-input placeholder="桥面高程" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱轴线</td>
                            <td class="table2-item-content">
                                <a-input placeholder="拱轴线" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主缆线形</td>
                            <td class="table2-item-content">
                                <a-input placeholder="主缆线形" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、锚碇的高程</td>
                            <td class="table2-item-content">
                                <a-input placeholder="墩、台身、锚碇的高程" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、索塔倾斜度</td>
                            <td class="table2-item-content">
                                <a-input placeholder="墩、台身、索塔倾斜度" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">索塔水平变位、高程</td>
                            <td class="table2-item-content">
                                <a-input placeholder="索塔水平变位、高程" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱桥桥台、悬索桥锚碇水平位移</td>
                            <td class="table2-item-content">
                                <a-input placeholder="拱桥桥台、悬索桥锚碇水平位移" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">悬索桥索夹螺栓紧固力</td>
                            <td class="table2-item-content">
                                <a-input placeholder="悬索桥索夹螺栓紧固力" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">水中基础</td>
                            <td class="table2-item-content">
                                <a-input placeholder="水中基础" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">斜拉索或吊杆索力</td>
                            <td class="table2-item-content">
                                <a-input placeholder="斜拉索或吊杆索力" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主要承重构建尺寸</td>
                            <td class="table2-item-content">
                                <a-input placeholder="主要承重构建尺寸" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">材料强度</td>
                            <td class="table2-item-content">
                                <a-input placeholder="材料强度" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">保护层厚度</td>
                            <td class="table2-item-content">
                                <a-input placeholder="保护层厚度" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">钢管混凝土管内混凝土密实度</td>
                            <td class="table2-item-content">
                                <a-input placeholder="钢管混凝土管内混凝土密实度" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">静载试验结果</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="静载试验结果" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table"></table>
                        <td class="table2-item-name">动载试验结果</td>
                            <td class="table2-item-content">
                                <a-textarea v-model:value="otr_sig" placeholder="动载试验结果" show-count :maxlength="200" allow-clear
                                style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                            </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="init-card-table">
                            <tr>
                                <td class="table3-item-name">记录人</td>
                                <td class="table3-item-content">
                                    <a-input placeholder="记录人" style="height: 3em;"/>
                                </td>
                                <td class="table3-item-name">桥梁工程师</td>
                                <td class="table3-item-content">
                                    <a-input placeholder="桥梁工程师" style="height: 3em;"/>
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">桥梁初始检查机构</td>
                            <td class="table2-item-content">
                                <a-input placeholder="桥梁初始检查机构" style="height: 3em;"/>
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                </a-form>
            </div>
        </a-skeleton>
        <div class="footer-bar" v-if="!loading">
            <a-button type="primary" style="margin-bottom: 1em">
                <template #icon>
                    <CloudUploadOutlined />
                </template>
            </a-button>
            <a-button type="primary">
                <template #icon>
                    <ArrowLeftOutlined />
                </template>
            </a-button>
        </div>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent, ref } from 'vue';
import { CloudUploadOutlined, ArrowLeftOutlined } from '@ant-design/icons-vue'
import { useUserStore } from "../../store/user.ts";
import type { SelectProps } from "ant-design-vue";
import { useRoute }  from "vue-router";

const value1= ref("")

const options = ref<SelectProps['options']>([
    {
        value: '全',
        label: '全',
    },
    {
        value: "不全",
        label: '不全',
    },
    {
        value: "无",
        label: '无',
    },
])

interface Bridge_route {
    bridge_no:string
    bridge_name: string
    route_no:string
    route_name:string
    route_rank:string
}

export default defineComponent({
    components: {
        CloudUploadOutlined,
        ArrowLeftOutlined,
    },
    setup() {
        const route = useRoute();
        let loading = ref(true)
        const userStore = useUserStore()

        const otr_sig = ref<string>("无")

        const bridge_route = ref<Bridge_route>()
        const init = () => {
            setTimeout(() => {
                loading.value = false
            }, 1000)
            axios({
                url: 'http://localhost:3000/api/bridge/get/route',
                method:'GET',
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                console.log(resp.data)
                bridge_route.value = resp.data[0]
                console.log(bridge_route.value)
            })
        }
        init()


        return {
            bridge_route,
            value1,
            loading,
            otr_sig,
            userStore,
            options,
        }
    }
})

</script>

<style scoped>

.init-card-container {
    overflow: hidden auto;
    width: 95%;
}

.header-tips {
    height: 2em;
    margin-bottom: 1em;
    width: 95%;
    background-color: #7ac0fc;
    font-size: 1.2em;
    text-align: center;
    line-height: 2em;
}

.footer-bar {
    position: absolute;
    display: flex;
    flex-direction: column;
    top: 100px;
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

.init-card-form {
    padding: 1em;
    border-radius: .3em;
    background-color: #FFF;
    box-shadow: none;
}

.ant-form-item {
    margin: .7em;
}

.init-card-table {
    border-collapse: separate;
    border-spacing: .5em .5em;
    text-align: center;
    width: 100%;
}

.table-item-name {
    width: 10%;
}
.table-item-content {
    width: 20%;
}
.table2-item-name {
    display: table-cell; 
    vertical-align: middle;
    width: 10vw;
}
.table2-item-content {
    width: 70vw;
}
.table3-item-name {
    width: 15%;
}
.table3-item-content {
    width: 30%;
}

.assess-record-table {
    border-collapse: collapse;
    text-align: center;
    width: 100%;
}

.assess-record-tr {
    border-bottom: 1px solid #6c6969;
    height: 3em;
}

hr {
    margin: 0;
}

.photo-box {
    height: 15em;
}
</style>