<template>
    <div class="init-card">
        <div class="header-tips">
            你当前正在编写编号为{{ $route.query.bridge_no }}的桥梁定期检查记录表
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
                                    <a-input v-model:value=cardInfo.bridge_info.route_no placeholder="路线编号" disabled />
                                </td>
                                <td class="table-item-name">路线名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.bridge_info.route_name placeholder="路线名称" disabled />
                                </td>
                                <td class="table-item-name">桥位桩号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.initCard.bridge_pile placeholder="桥位桩号" disabled />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁编号</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=$route.query.bridge_no placeholder="桥梁编号" disabled />
                                </td>
                                <td class="table-item-name">桥梁名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.bridge_info.bridge_name placeholder="桥梁名称" disabled />
                                </td>
                                <td class="table-item-name">被跨越道路(通道)名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.initCard.cro_name placeholder="被跨越道路(通道)名称" disabled />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">桥梁全长(m)</td>
                                <td class="table-item-content">
                                    <a-input-number v-model:value=cardInfo.initCard.bri_len placeholder="桥梁全长(m)" :min="0"
                                        :max="999999.99" style="width: 100%;" disabled />
                                </td>
                                <td class="table-item-name">主跨结构</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.main_spa_stru placeholder="主跨结构"
                                        :maxlength="20" />
                                </td>
                                <td class="table-item-name">最大跨径(m)</td>
                                <td class="table-item-content">
                                    <a-input-number v-model:value=cardInfo.initCard.bri_cro_len placeholder="最大跨径(m)"
                                        :min="0" :max="999999.99" style="width: 100%;" disabled />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">管养单位名称</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=userStore.unit_name disabled />
                                </td>
                                <td class="table-item-name">建成时间</td>
                                <td class="table-item-content">
                                    <a-date-picker v-model:value=cardInfo.basicCard.build_time
                                        style="height: 2em; width: 100%;" value-format="YYYY-MM-DD" format="YYYY-MM-DD"
                                        :locale="locale" placeholder="建成时间" disabled />
                                </td>
                                <td class="table-item-name">上次修复养护时间</td>
                                <td class="table-item-content">
                                    <a-date-picker v-model:value=cardInfo.arr.las_rema_time
                                        style="height: 2em; width: 100%;" value-format="YYYY-MM-DD" format="YYYY-MM-DD"
                                        :locale="locale" placeholder="上次修复养护时间" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">上次检查时间</td>
                                <td class="table-item-content">
                                    <a-date-picker v-model:value=cardInfo.arr.las_insp_time
                                        style="height: 2em; width: 100%;" value-format="YYYY-MM-DD" format="YYYY-MM-DD"
                                        :locale="locale" placeholder="上次检查时间" />
                                </td>
                                <td class="table-item-name">本次检查时间</td>
                                <td class="table-item-content">
                                    <a-date-picker v-model:value=cardInfo.arr.now_insp_time
                                        style="height: 2em; width: 100%;" value-format="YYYY-MM-DD" format="YYYY-MM-DD"
                                        :locale="locale" placeholder="本次检查时间" />
                                </td>
                                <td class="table-item-name">本次检查时气候及环境温度</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.now_insp_envir placeholder="本次检查时气候及环境温度"
                                        :maxlength="20" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <div class="stru_record_container">
                            <a-row class="stru_record_row">
                                <a-col :span="2">
                                    <p class="table_head">部位</p>
                                </a-col>
                                <a-col :span="2">
                                    <p class="table_head">部件名称</p>
                                </a-col>
                                <a-col :span="2">
                                    <p class="table_head">评分</p>
                                </a-col>
                                <a-col :span="10">
                                    <a-row class="stru_record_row">
                                        <p class="table_head">缺损</p>
                                    </a-row>
                                    <a-row>
                                        <a-col :span="4">
                                            <p class="table_head">类型</p>
                                        </a-col>
                                        <a-col :span="4">
                                            <p class="table_head">位置</p>
                                        </a-col>
                                        <a-col :span="4">
                                            <p class="table_head">范围</p>
                                        </a-col>
                                        <a-col :span="6">
                                            <p class="table_head">照片</p>
                                        </a-col>
                                        <a-col :span="6">
                                            <p class="table_head">最不利构件</p>
                                        </a-col>
                                    </a-row>

                                </a-col>
                                <a-col :span="5">
                                    <p class="table_head">养护建议(维修范围、方式、时间)</p>
                                </a-col>
                                <a-col :span="3">
                                    <p class="table_head">是否需特殊检查</p>
                                </a-col>
                            </a-row>
                        </div>
                        <hr>
                        <div class="none-data-tips" v-if="bridgeStruct.arr.length === 0">
                            暂无数据
                        </div>
                        <div class="stru_record_container" v-if="bridgeStruct.arr.length != 0"
                            v-for="item in bridgeStruct.arr">
                            <a-row class="stru_record_row">
                                <a-col :span="2">
                                    <p class="table_part_name">{{ item.partName }}</p>
                                </a-col>
                                <a-col :span="22">
                                    <table class="stru_record_table">
                                        <tr v-for="cetPart in item.cetParts">
                                            <td style="width: 9%">
                                                <P class="table_content">{{ cetPart.cet_part_name }}</P>
                                            </td>
                                            <td style="width: 8%">
                                                <P class="table_content">{{ cetPart.score }}</P>
                                            </td>
                                            <td style="width: 7%">
                                                <P class="table_content">{{ cetPart.dft_type }}</P>
                                            </td>
                                            <td style="width: 7%">
                                                <P class="table_content">{{ cetPart.dft_position }}</P>
                                            </td>
                                            <td style="width: 8%">
                                                <P class="table_content">{{ cetPart.dft_range }}</P>
                                            </td>
                                            <td style="width: 11%">
                                                <P class="table_content">{{ cetPart.dft_photo }}</P>
                                            </td>
                                            <td style="width: 9%">
                                                <P class="table_content">{{ cetPart.dft_most_part }}</P>
                                            </td>
                                            <td style="width: 20%">
                                                <P class="table_content">{{ cetPart.mte_suggest }}</P>
                                            </td>
                                            <td style="width: 14%">
                                                <P class="table_content">{{ cetPart.spc_inspect }}</P>
                                            </td>
                                        </tr>
                                    </table>
                                </a-col>
                            </a-row>
                            <hr>
                        </div>
                    </a-form-item>
                    <hr>
                    <a-form-item>
                        <table class="card-table">
                            <tr>
                                <td class="table-item-name">桥梁技术状况评定等级</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.brid_coun_rat placeholder="桥梁技术状况评定等级" />
                                </td>
                                <td class="table-item-name">全桥清洁状况</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.brid_cle_condi placeholder="全桥清洁状况" />
                                </td>
                                <td class="table-item-name">预防及修复养护状况</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.pre_ma_sta placeholder="预防及修复养护状况" />
                                </td>
                            </tr>
                            <tr>
                                <td class="table-item-name">记录人</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.recorder placeholder="记录人" :maxlength="20" />
                                </td>
                                <td class="table-item-name">负责人</td>
                                <td class="table-item-content">
                                    <a-input v-model:value=cardInfo.arr.res_per placeholder="负责人" />
                                </td>
                                <td class="table-item-name">下次检查时间</td>
                                <td class="table-item-content">
                                    <a-date-picker v-model:value=cardInfo.arr.nex_insp_time
                                        style="height: 2em; width: 100%;" value-format="YYYY-MM-DD" format="YYYY-MM-DD"
                                        :locale="locale" placeholder="下次检查时间" />
                                </td>
                            </tr>
                        </table>
                    </a-form-item>
                    <hr>
                </a-form>
            </div>
        </a-skeleton>

        <a-modal v-model:visible="visible" title="部件记录录入" ok-text="确认" cancel-text="取消" @ok="handleOk" @cancel="cleanInput">
            <p class="tip" style="margin-top: 0;">桥梁部件:</p>
            <a-select 
                class="input-record" 
                v-model:value="cetPart.cet_part_no" 
                style="width: 100%;"
                :options="cetParts" :field-names="{ label: 'cet_part_name', value: 'cet_part_no' }" 
            />
            <a-input-number 
                class="input-record" 
                v-model:value=cetPart.score 
                placeholder="评分" 
                :precision="2"
                :min="0" 
                :max="100" 
                style="width: 100%;"
            />
            <p class="tip">缺损:</p>
            <a-input 
                class="input-record" 
                v-model:value="cetPart.dft_type" 
                placeholder="缺损类型" 
            />
            <a-input 
                class="input-record" 
                v-model:value="cetPart.dft_position" 
                placeholder="缺损位置" 
            />
            <a-input 
                class="input-record" 
                v-model:value="cetPart.dft_range" 
                placeholder="缺损范围" 
            />
            <a-input 
                class="input-record" 
                v-model:value="cetPart.dft_photo" 
                placeholder="缺损图片" 
            />
            <a-input 
                class="input-record" 
                v-model:value="cetPart.dft_most_part" 
                placeholder="缺损最不利构件" 
            />
            <p class="tip">其他:</p>
            <a-input 
                class="input-record" 
                v-model:value="cetPart.mte_suggest" 
                placeholder="养护建议(维修范围、方式、时间)" 
            />
            <p class="tip">是否需要特殊检查:</p>
            <a-select 
                class="input-record" 
                v-model:value="cetPart.spc_inspect" 
                style="width: 100%;"
                :options="options"
            />
            
        </a-modal>

        <div class="footer-bar" v-if="!loading">
            <a-tooltip placement="left">
                <template #title>
                    <span>上传定期检查记录表</span>
                </template>
                <a-button type="primary" style="margin-bottom: 1em" @click="submitData" :disabled="$route.query.status === 'finish'">
                    <template #icon>
                        <CloudUploadOutlined />
                    </template>
                </a-button>
            </a-tooltip>
            <a-tooltip placement="left">
                <template #title>
                    <span>返回上一级</span>
                </template>
                <a-button type="primary" style="margin-bottom: 1em" @click="$router.back()">
                    <template #icon>
                        <ArrowLeftOutlined />
                    </template>
                </a-button>
            </a-tooltip>
            <a-tooltip placement="left">
                <template #title>
                    <span>添加部件检查信息</span>
                </template>
                <a-button type="primary" @click="visible = true" :disabled="$route.query.status === 'finish'">
                    <template #icon>
                        <PlusOutlined />
                    </template>
                </a-button>
            </a-tooltip>
        </div>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { defineComponent, ref, reactive } from 'vue';
import { CloudUploadOutlined, ArrowLeftOutlined, PlusOutlined } from '@ant-design/icons-vue'
import { useUserStore } from "../../store/user.ts";
import { useRoute } from "vue-router";
import { error_message } from "../../utils/errorMessage.ts";
import locale from "ant-design-vue/lib/time-picker/locale/zh_CN";
import type { Dayjs } from 'dayjs'
import type { SelectProps } from "ant-design-vue";
import router from '../../router';

const options = ref<SelectProps['options']>([
	{
		value: '需要',
		label: '需要',
	},
	{
		value: "不需要",
		label: '不需要',
	},
])
export default defineComponent({
    components: {
        CloudUploadOutlined,
        ArrowLeftOutlined,
        PlusOutlined,
    },
    setup() {
        const userStore = useUserStore()
        const route = useRoute()
        let loadingCount = 0
        let loading = ref(true)

        let visible = ref(false)
        const cetParts = ref([])

        const cardInfo = reactive({
            bridge_info: {
                bridge_name: '',
                route_no: '',
                route_name: '',
                route_rank: '',
            },
            arr: {
                las_rema_time: ref<Dayjs>(),
                las_insp_time: ref<Dayjs>(),
                now_insp_time: ref<Dayjs>(),
                now_insp_envir: '',
                brid_coun_rat: '',
                brid_cle_condi: '',
                pre_ma_sta: '',
                recorder: '',
                res_per: '',
                nex_insp_time: ref<Dayjs>(),
                main_spa_stru: '',
            },
            initCard: {
                bridge_pile: '',
                cro_name: '',
                bri_len: Number,
                bri_cro_len: Number,
            },
            basicCard: {
                build_time: ref<Dayjs>(),
            }
        })

        const bridgeStruct = reactive({
            arr: [
                {
                    partName: '',
                    cetParts: [
                        {
                            cet_part_name: '',
                            score: '',
                            dft_type: '',
                            dft_position: '',
                            dft_range: '',
                            dft_photo: '',
                            dft_most_part: '',
                            mte_suggest: '',
                            spc_inspect: ''
                        }
                    ]
                }
            ]
        })

        const cetPart = reactive({
            cet_part_no: '',
            score: '',
            dft_type: '',
            dft_position: '',
            dft_range: '',
            dft_photo: '',
            dft_most_part: '',
            mte_suggest: '',
            spc_inspect: ''
        })

        const checkInput = () => {
            if (cetPart.cet_part_no === '' || cetPart.score === '' || cetPart.dft_type === ''
                || cetPart.dft_position === '' || cetPart.dft_range === '' || cetPart.dft_photo === ''
                || cetPart.dft_most_part === '' || cetPart.mte_suggest === '' || cetPart.spc_inspect === '')
                return false
            return true
        }

        const handleOk = () => {
            if (! checkInput() ) {
                error_message("请规范输入内容", "error");
                return
            }
            handleAdd()
        }

        const cleanInput = () => {
            visible.value = false

            cetPart.cet_part_no= '',
            cetPart.score = '',
            cetPart.dft_type= '',
            cetPart.dft_position= '',
            cetPart.dft_range= '',
            cetPart.dft_photo= '',
            cetPart.dft_most_part= '',
            cetPart.mte_suggest= '',
            cetPart.spc_inspect= ''
        }

        const handleAdd = () => {
            axios({
                url:'http://localhost:3000/api/periCard/add/structRecord',
                method:"POST",
                params:{
                    cet_part_no: cetPart.cet_part_no,
                    score: cetPart.score,
                    dft_type: cetPart.dft_type,
                    dft_position: cetPart.dft_position,
                    dft_range: cetPart.dft_range,
                    dft_photo: cetPart.dft_photo,
                    dft_most_part: cetPart.dft_most_part,
                    mte_suggest: cetPart.mte_suggest,
                    spc_inspect: cetPart.spc_inspect
                }
            }).then((resp) => {
                if (resp.data.error_info === 'success') {
                    error_message("成功", "success")
                    cleanInput()
                    getStruRecord()
                } else {
                    error_message(resp.data.error_info, "error")
                }
            })
        }

        const getBridgeRoute = () => {
            axios({
                url: 'http://localhost:3000/api/route/get/bno',
                method: "GET",
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                cardInfo.bridge_info = resp.data
                loadingCount += 1
            })
        }
        getBridgeRoute()

        const getBuildTime = () => {
            axios({
                url: 'http://localhost:3000/api/periCard/get/buildTime',
                method: "GET",
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                cardInfo.basicCard = resp.data
                loadingCount += 1
            })
        }
        getBuildTime()

        const getCetParts = () => {
            axios({
                url: 'http://localhost:3000/api/cetPart/get',
                method: 'GET',
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                cetParts.value = resp.data
            })
        }
        getCetParts()

        const getStruRecord = () => {
            axios({
                url: 'http://localhost:3000/api/periCard/get/structRecord',
                method: "GET",
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                bridgeStruct.arr = resp.data
            })
        }
        getStruRecord()

        const getInitCardInfo = () => {
            axios({
                url: 'http://localhost:3000/api/periCard/get/initCardInfo',
                method: "GET",
                params: {
                    bridge_no: route.query.bridge_no
                }
            }).then((resp) => {
                cardInfo.initCard = resp.data
                loadingCount += 1
            })
        }
        getInitCardInfo()


        const checkDataFormat = () => {
            if(
                cardInfo.arr.las_rema_time == null || 
                cardInfo.arr.las_insp_time == null || 
                cardInfo.arr.now_insp_time == null || 
                cardInfo.arr.now_insp_envir === '' ||
                cardInfo.arr.brid_coun_rat === '' ||
                cardInfo.arr.brid_cle_condi === '' ||
                cardInfo.arr.pre_ma_sta === '' ||
                cardInfo.arr.recorder === '' ||
                cardInfo.arr.res_per === '' ||
                cardInfo.arr.nex_insp_time == null ||
                cardInfo.arr.main_spa_stru === ''
            ){
                error_message("存在未填写数据", 'error')
                return false;
            }
            else return true;
        }


        const submitData = () => {
            if (!checkDataFormat()) return
            else {
                error_message("所有数据合法，正在上传初始检查记录表", "success");
            }
            axios({
                url:'http://localhost:3000/api/periCard/submit',
                method:"POST",
                params: {
                    bridge_no: route.query.bridge_no,
                    cardInfo: JSON.stringify(cardInfo.arr),
                }
            }).then((resp) => {
                error_message(resp.data.error_info, resp.data.error_info)
                router.push({name: "informationIndex"})
            }).catch(() => {
                error_message("提交失败", "error")
            })
        }

        const getCardInfo = () => {
            axios({
				url:'http://localhost:3000/api/periCard/get/cardInfo',
				method:"GET",
				params: {
					bridge_no: route.query.bridge_no,
				}
			}).then((resp) => {
                cardInfo.arr = resp.data
                loadingCount += 1
			})
        }
        if (route.query.status === 'finish') getCardInfo();

        const checkInterval = setInterval(() => {
            let needCount = 3
            if (route.query.status == 'finish') needCount = 4
            if (loadingCount == needCount) {
                loading.value = false
                clearInterval(checkInterval)
            }
        }, 500)


        return {
            cardInfo,
            bridgeStruct,
            cetPart,
            cetParts,

            submitData,
            cleanInput,
            handleOk,

            loading,
            userStore,
            locale,
            visible,
            options,
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

.stru_record_table {
    text-align: center;
    width: 100%;
    table-layout: fixed;
}

.stru_record_container {
    padding: .5em;
    text-align: center;
}

.table_head {
    width: 100%;
    font-size: 1em;
    font-weight: bolder;
    text-align: center;
    margin: 0;
}

.stru_record_row {
    display: flex;
    align-items: center;
}

.table_part_name {
    display: block;
    width: 100%;
    font-size: 1em;
    text-align: center;
    margin: 0;
}

.table_content {
    width: 100%;
    font-size: 1em;
    text-align: center;
    margin: 0;
    display: block;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    height: 100%;
}

.none-data-tips {
    width: 100%;
    height: 3em;
    font-size: 2em;
    text-align: center;
    line-height: 3em;
}
.tip {
    margin: 0.5em;
    margin-top: 1em;
    padding: 0;
}
.input-record {
    margin: .5em;
    height: 2.5em;
}
hr {
    margin: 0;
}
</style>