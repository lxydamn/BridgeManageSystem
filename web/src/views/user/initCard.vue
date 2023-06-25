<template>
    <div class="init-card">
        <div class="header-tips">
            你当前正在编写编号为{{ $route.query.bridge_no }}的桥梁初始检查记录表
        </div>
        <a-skeleton :loading="loading" active>
            <div class="card-container" v-if="!loading">
                <a-form layout="horizontal" class="card-form">
                    <hr>
                    <a-form-item>
                        <table class="card-table">
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
                        <table class="card-table">
                            <tr>
                                <td class="table-item-name">路线编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.route_no placeholder="路线编号" disabled />
                                </td>
                                <td class="table-item-name">路线名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.route_name placeholder="路线名称" disabled />
                                </td>
                                <td class="table-item-name">桥位桩号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_pile placeholder="桥位桩号" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.bridge_no placeholder="桥梁编号" disabled />
                                </td>
                                <td class="table-item-name">桥梁名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bridge_route.vridge_name placeholder="桥梁名称" disabled />
                                </td>
                                <td class="table-item-name">被跨越道路(通道)名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cro_name placeholder="被跨越道路(通道)名称" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">被跨越道路(通道)桩号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cro_no placeholder="被跨越道路(通道)桩号" />
                                </td>
                                <td class="table-item-name">桥梁全长(m)</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bri_len placeholder="桥梁全长(m)" />
                                </td>
                                <td class="table-item-name">最大跨径(m)</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=bri_cro_len placeholder="最大跨径(m)" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">上、下部结构形式</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="up_dow_stru_form" placeholder="上、下部结构形式" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">桥梁分联及跨径组合</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="bridge_jo_spa_comb" placeholder="桥梁分联及跨径组合" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">桥梁施工方法</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="brid_constr_meth" placeholder="桥梁施工方法" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">新建桥梁在施工过程中的返工、维修或加固情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="new_mat_rf_costi" placeholder="新建桥梁在施工过程中的返工、维修或加固情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">加固改造后的桥梁，加固改造情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="refo_reno_costi" placeholder="加固改造后的桥梁，加固改造情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">档案资料不齐全的桥梁，维修加固情况</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="lac_mat_rf_costi" placeholder="档案资料不齐全的桥梁，维修加固情况" show-count
                                :maxlength="200" allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">设计单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value="design_unit" :options="units" style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">施工单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value="construction_unit" :options="units"
                                        style="height: 2em;"></a-select>
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">管养单位名称</td>
                                <td class="table3-item-content">
                                    <a-select v-model:value="custody_unit" :options="units" style="height: 2em;"></a-select>
                                </td>
                                <td class="table3-item-name">交工时间</td>
                                <td class="table3-item-content">
                                    <a-date-picker v-model:value="del_time" style="height: 2em; width: 100%;" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">初始检查</td>
                                <td class="table3-item-content">
                                    <a-date-picker v-model:value="init_time" style="height: 2em; width: 100%;" />
                                </td>
                                <td class="table3-item-name">初始检查时的气候及环境温度</td>
                                <td class="table3-item-content">
                                    <a-input v-model:value=init_recor_envir placeholder="初始检查时的气候及环境温度" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">桥面高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=Brid_deck_ele placeholder="桥面高程" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱轴线</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=axis_arch placeholder="拱轴线" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主缆线形</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=main_cab_shape placeholder="主缆线形" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、锚碇的高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=pie_pla_anc_ele placeholder="墩、台身、锚碇的高程" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">墩、台身、索塔倾斜度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=pie_pla_py_incl placeholder="墩、台身、索塔倾斜度" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">索塔水平变位、高程</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=hori_sh_ele_tow placeholder="索塔水平变位、高程" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">拱桥桥台、悬索桥锚碇水平位移</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=brid_hori_dis_anch_sus placeholder="拱桥桥台、悬索桥锚碇水平位移"
                                    style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">悬索桥索夹螺栓紧固力</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=sus_brid_fasfor placeholder="悬索桥索夹螺栓紧固力" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">水中基础</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=under_foda placeholder="水中基础" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">斜拉索或吊杆索力</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=stca_bo_cabfo placeholder="斜拉索或吊杆索力" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">主要承重构建尺寸</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=main_lobe_mem_dimen placeholder="主要承重构建尺寸" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">材料强度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=mate_stren placeholder="材料强度" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">保护层厚度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=stepi_coma placeholder="保护层厚度" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">钢管混凝土管内混凝土密实度</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=pro_thick placeholder="钢管混凝土管内混凝土密实度" style="height: 3em;" />
                            </td>
                        </tr>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">静载试验结果</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="sta_tes_res" placeholder="静载试验结果" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table"></table>
                        <td class="table2-item-name">动载试验结果</td>
                        <td class="table2-item-content">
                            <a-textarea v-model:value="dyn_tes_res" placeholder="动载试验结果" show-count :maxlength="200"
                                allow-clear style="margin: 1em auto 1em;" :autosize="{ minRows: 4 }" />
                        </td>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table3-item-name">记录人</td>
                                <td class="table3-item-content">
                                    <a-input v-model:value=recorder placeholder="记录人" style="height: 3em;" />
                                </td>
                                <td class="table3-item-name">桥梁工程师</td>
                                <td class="table3-item-content">
                                    <a-input v-model:value=brid_engi placeholder="桥梁工程师" style="height: 3em;" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <tr>
                            <td class="table2-item-name">桥梁初始检查机构</td>
                            <td class="table2-item-content">
                                <a-input v-model:value=brid_init_ins_mecha placeholder="桥梁初始检查机构" style="height: 3em;" />
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
            <a-button type="primary" @click="$router.back()">
                <template #icon>
                    <ArrowLeftOutlined />
                </template>
            </a-button>
        </div>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, ref } from 'vue';
import { CloudUploadOutlined, ArrowLeftOutlined } from '@ant-design/icons-vue'
import { useRoute } from "vue-router";

interface Bridge_route {
    bridge_name: string
    route_no: string
    route_name: string
    route_rank: string
}

interface OptionItem {
    label: string,
    value: string
}

export default defineComponent({
    components: {
        CloudUploadOutlined,
        ArrowLeftOutlined,
    },
    setup() {
        const route = useRoute();
        let loadingCount = 0
        let loading = ref(true)

        const bridge_route = ref<Bridge_route>()
        const bridge_pile = ref("")
        const cro_name = ref("")
        const cro_no = ref("")
        const bri_len = ref("")
        const bri_cro_len = ref("")

        const up_dow_stru_form = ref("")
        const bridge_jo_spa_comb = ref("")
        const brid_constr_meth = ref("")
        const new_mat_rf_costi = ref("")
        const refo_reno_costi = ref("")
        const lac_mat_rf_costi = ref("")

        const units: Ref<OptionItem[]> = ref([])
        const design_unit = ref("")
        const construction_unit = ref("")
        const custody_unit = ref("")
        const del_time = ref("")
        const init_time = ref("")
        const init_recor_envir = ref("")

        const Brid_deck_ele = ref("")
        const axis_arch = ref("")
        const main_cab_shape = ref("")
        const pie_pla_anc_ele = ref("")
        const pie_pla_py_incl = ref("")
        const hori_sh_ele_tow = ref("")
        const brid_hori_dis_anch_sus = ref("")
        const sus_brid_fasfor = ref("")
        const under_foda = ref("")
        const stca_bo_cabfo = ref("")
        const main_lobe_mem_dimen = ref("")
        const mate_stren = ref("")
        const stepi_coma = ref("")
        const pro_thick = ref("")

        const sta_tes_res = ref("")
        const dyn_tes_res = ref("")

        const recorder = ref("")
        const brid_engi = ref("")
        const brid_init_ins_mecha = ref("")

        const getBridgeRoute = () => {
            axios({
				url:'http://localhost:3000/api/route/get/bno',
				method:"GET",
				params: {
					bridge_no: route.query.bridge_no
				}
			}).then((resp) => {
                bridge_route.value = resp.data
			})
            loadingCount += 1
        }
        getBridgeRoute()

        const getUnit = () => {
            axios({
                url: 'http://localhost:3000/api/unit/get/all',
                method: 'GET',
            }).then((resp) => {
                for (let i = 0; i < resp.data.length; i++) {
                    units.value.push({
                        value: resp.data[i]['unit_no'],
                        label: resp.data[i]['unit_name'],
                    })
                }
                loadingCount += 1
            })
        }
        getUnit()

        const checkInterval = setInterval(() => {
            if (loadingCount == 2) {
                loading.value = false
                clearInterval(checkInterval)
            }
        }, 500)


        return {
            bridge_route,
            bridge_pile,
            cro_name,
            cro_no,
            bri_len,
            bri_cro_len,

            up_dow_stru_form,
            bridge_jo_spa_comb,
            brid_constr_meth,
            new_mat_rf_costi,
            refo_reno_costi,
            lac_mat_rf_costi,

            design_unit,
            construction_unit,
            custody_unit,
            del_time,
            init_time,
            init_recor_envir,

            Brid_deck_ele,
            axis_arch,
            main_cab_shape,
            pie_pla_anc_ele,
            pie_pla_py_incl,
            hori_sh_ele_tow,
            brid_hori_dis_anch_sus,
            sus_brid_fasfor,
            under_foda,
            stca_bo_cabfo,
            main_lobe_mem_dimen,
            mate_stren,
            stepi_coma,
            pro_thick,

            sta_tes_res,
            dyn_tes_res,

            recorder,
            brid_engi,
            brid_init_ins_mecha,

            loading,
            units,
        }
    }
})

</script>

<style scoped>
.card-container {
    overflow: hidden auto;
    width: 95%;
}

.header-tips {
    position: sticky;
    top: -1em;
    z-index: 2;
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

.card-form {
    padding: 1em;
    border-radius: .3em;
    background-color: #FFF;
    box-shadow: none;
}

.ant-form-item {
    margin: .7em;
}

.card-table {
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

hr {
    margin: 0;
}
</style>