<template>
	<div class="header-tips">
		你当前正在编写编号为{{$route.query.bridge_no}}的桥梁基本卡片
	</div>
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
								<a-input
										placeholder="桥梁所属行政区代码"
										v-model:value="cardInfo.arr.admin_code"
								/>
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
								<a-input placeholder="路线编号" disabled v-model:value="cardInfo.route.route_no" />
							</td>
							<td class="table-item-name">路线名称</td>
							<td class="table-item-content">
								<a-input placeholder="路线编号" disabled v-model:value="cardInfo.route.route_name" />
							</td>
							<td class="table-item-name">路线等级</td>
							<td class="table-item-content">
								<a-input placeholder="路线编号" disabled v-model:value="cardInfo.route.route_rank" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥梁编号</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁编号" disabled v-model:value="cardInfo.arr.bridge_no" />
							</td>
							<td class="table-item-name">桥梁名称</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁名称" disabled v-model:value="cardInfo.route.bridge_name" />
							</td>
							<td class="table-item-name">桥位桩号</td>
							<td class="table-item-content">
								<a-input
										placeholder="桥位桩号"
										disabled
										v-model:value="initCardData.data.bridge_pile"
								/>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">功能类型</td>
							<td class="table-item-content">
								<a-input placeholder="功能类型" v-model:value="cardInfo.arr.fun_type"  />
							</td>
							<td class="table-item-name">被跨越道路名称</td>
							<td class="table-item-content">
								<a-input
										placeholder="被跨越道路名称"
										disabled
										v-model:value="initCardData.data.cro_name"
								/>
							</td>
							<td class="table-item-name">被跨越道路桩号</td>
							<td class="table-item-content">
								<a-input
										placeholder="被跨越道路桩号"
										disabled
										v-model:value="initCardData.data.cro_no"
								/>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">设计载荷</td>
							<td class="table-item-content">
								<a-input placeholder="设计载荷" v-model:value="cardInfo.arr.des_load" />
							</td>
							<td class="table-item-name">桥梁坡度</td>
							<td class="table-item-content">
								<a-input-number  class="input-item-default" suffix="°" pattern="[0-9]*" placeholder="桥梁坡度" v-model:value="cardInfo.arr.bridge_slope" />
							</td>
							<td class="table-item-name">桥梁平曲线半径</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" suffix="m" pattern="[0-9]*" placeholder="桥梁平曲线半径" v-model:value="cardInfo.arr.bridge_radius" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">建成时间</td>
							<td class="table-item-content">
								<a-date-picker
                    value-format="YYYY-MM-DD"
                    :locale="locale"
										class="input-item-default"
                    format="YYYY-MM-DD"
										placeholder="建成时间"
										v-model:value="cardInfo.arr.build_time"
								/>
							</td>
							<td class="table-item-name">设计单位</td>
							<td class="table-item-content">
								<a-input
                    placeholder="设计单位"
                    disabled
                    v-model:value="initCardData.data.des_unit"
                />
							</td>
							<td class="table-item-name">施工单位</td>
							<td class="table-item-content">
								<a-input
                    placeholder="施工单位"
                    disabled
                    v-model:value="initCardData.data.cst_unit"
                />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">监理单位</td>
							<td class="table-item-content">
								<a-select
										class="input-item-default"
										v-model:value="cardInfo.units.spr_unit"
										:options="units"
										:field-names="{label:'unit_name', value:'unit_no'}"
								></a-select>
							</td>
							<td class="table-item-name">业主单位</td>
							<td class="table-item-content">
								<a-select
										class="input-item-default"
										v-model:value="cardInfo.units.own_unit"
										:options="units"
										:field-names="{label:'unit_name', value:'unit_no'}"
								></a-select>
							</td>
							<td class="table-item-name">管养单位</td>
							<td class="table-item-content">
								<a-input placeholder="管养单位" disabled v-model:value="userStore.unit_name" />
							</td>
						</tr>
					</table>
				</a-form-item>
				<h3>桥梁技术指标</h3>
				<hr>
				<a-form-item>
					<table class="basic-card-table">
						<tr>
							<td class="table-item-name">桥梁全长</td>
							<td class="table-item-content">
								<a-input-number
										class="input-item-default"
										placeholder="桥梁全长"
										disabled
										v-model:value="initCardData.data.bri_len"
								/>
							</td>
							<td class="table-item-name">桥面总宽</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="桥面总宽" v-model:value="techIndex.arr.bridge_wdh" />
							</td>
							<td class="table-item-name">车道宽度</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="车道宽度" v-model:value="techIndex.arr.car_wdh" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">人行道宽度</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="人行道宽度" v-model:value="techIndex.arr.psn_wdh" />
							</td>
							<td class="table-item-name">护栏或防撞墙高度</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default"  placeholder="护栏或防撞墙高度" v-model:value="techIndex.arr.pet_hgt" />
							</td>
							<td class="table-item-name">中央分隔带高度</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="中央分隔带高度" v-model:value="techIndex.arr.ctr_dvr_wdh" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥面标准净空</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="桥面标准净空" v-model:value="techIndex.arr.std_hrm" />
							</td>
							<td class="table-item-name">桥面实际净空</td>
							<td class="table-item-content">
								<a-input-number  class="input-item-default" placeholder="桥面实际净空" v-model:value="techIndex.arr.act_hrm" />
							</td>
							<td class="table-item-name">桥下通航等级及标准净空</td>
							<td class="table-item-content">
								<a-input-number  class="input-item-default" placeholder="桥下通航等级及标准净空" v-model:value="techIndex.arr.std_trm" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥下实际净空</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="桥下实际净空" v-model:value="techIndex.arr.act_trm" />
							</td>
							<td class="table-item-name">引道总宽</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default"  placeholder="引道总宽" v-model:value="techIndex.arr.apr_wdh" />
							</td>
							<td class="table-item-name">引道线形或曲线半径</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default"  placeholder="引道线形或曲线半径" v-model:value="techIndex.arr.crv_rds" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">设计洪水频率及其水位</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default"  placeholder="设计洪水频率及其水位" v-model:value="techIndex.arr.des_fol_lev" />
							</td>
							<td class="table-item-name">历史洪水位</td>
							<td class="table-item-content">
								<a-input-number  class="input-item-default" placeholder="历史洪水位" v-model:value="techIndex.arr.his_fol_lev" />
							</td>
							<td class="table-item-name">设计地震动峰值加速度系数</td>
							<td class="table-item-content">
								<a-input-number class="input-item-default" placeholder="设计地震动峰值加速度系数" v-model:value="techIndex.arr.grd_pek_acc" />
							</td>
						</tr>
					</table>
				</a-form-item>
				<h3>桥梁结构信息</h3>
				<hr>
				<a-form-item>
					<div class="struct-container" v-for="item in bridgeStruct.arr">
						<a-row>
							<a-col :span="1" class="struct-main"> <h4> {{ item.struct }} </h4></a-col>
							<a-col :span="23">
								<table class="sub-struct-table" >
									<tr v-for="subItem in item.subStruct">
										<td style="width: 10%;"> {{ subItem.subName }} </td>
										<td v-for="data in subItem.subArr">{{ data.material }}</td>
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
							<td class="table-item-name">设计图纸</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.des_draw"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">设计文件</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.des_file"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">竣工图纸</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.fin_draw"
										:options="options">
								</a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">施工文件</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.cst_file"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">验收文件</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.acp_file"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">行政审批文件</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.adm_apv_file"
										:options="options">
								</a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">定期检查资料</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.per_chk_info"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">特殊检查资料</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.spc_chk_info"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">历次维修、加固资料</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.hsy_info"
										:options="options">
								</a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">其他档案</td>
							<td class="table-item-content">
								<a-select
										v-model:value="bridgeFile.arr.ohr_info"
										:options="options">
								</a-select>
							</td>
							<td class="table-item-name">档案形式</td>
							<td class="table-item-content">
								<a-select ref="select" v-model:value="bridgeFile.arr.file_type">
									<a-select-option value="电子档案">电子档案</a-select-option>
									<a-select-option value="纸质档案">纸质档案</a-select-option>
								</a-select>
							</td>
							<td class="table-item-name">建档时间</td>
							<td class="table-item-content">
								<a-date-picker
                    value-format="YYYY-MM-DD"
                    format="YYYY-MM-DD"
                    :locale="locale"
                    placeholder="建档时间"
                    class="input-item-default"
                    v-model:value="bridgeFile.arr.file_time"
                />
							</td>
						</tr>
					</table>
				</a-form-item>
				<h3>桥梁检测评定历史（动态）</h3>
				<hr>
				<a-form-item>
					<table class="assess-record-table">
						<tr class="assess-record-tr">
							<th>评定时间</th>
							<th>检测类别</th>
							<th>桥梁技术状况评定结果</th>
							<th>处治对策</th>
							<th>下次检测时间</th>
						</tr>
						<tr v-for="item in assessRecord.arr" class="assess-record-tr">
							<td> {{item.ase_time}} </td>
							<td> {{item.ase_type}} </td>
							<td> {{item.ase_rst}} </td>
							<td> {{item.ctr_mes}} </td>
							<td> {{item.nxt_time}} </td>
						</tr>
					</table>
					<div class="none-data-tips" v-if="assessRecord.arr.length === 0">
						暂无数据
					</div>
				</a-form-item>
				<h3>养护处治记录（加标题）</h3>
				<hr>
				<a-form-item>
					<table class="assess-record-table">
						<tr class="assess-record-tr">
							<th>时间</th>
							<th>处治类别</th>
							<th>处治原因</th>
							<th>处治范围</th>
							<th>工程费用</th>
							<th>经费来源</th>
							<th>处治质量评定</th>
						</tr>
						<tr v-for="item in maintainRecord.arr" class="assess-record-tr">
							<td> {{ item.tre_time }} </td>
							<td> {{ item.tre_type }} </td>
							<td> {{ item.tre_rea }} </td>
							<td> {{ item.tre_rge }} </td>
							<td> {{ item.pro_fee }} </td>
							<td> {{ item.ori_fee }} </td>
							<td> {{ item.tre_qlt_aes }} </td>
						</tr>
					</table>
					<div class="none-data-tips" v-if="maintainRecord.arr.length === 0">
						暂无数据
					</div>
				</a-form-item>
				<h3>说明事项（文本框）</h3>
				<hr>
				<a-form-item>
					<a-textarea
							v-model:value="cardInfo.arr.otr_sig"
							placeholder="输入说明事项"
							show-count
							:maxlength="200"
							allow-clear
							style="margin: 1em auto 1em;"
							:autosize="{minRows : 4}"
					/>
				</a-form-item>
				<h3>其他（参照卡片）</h3>
				<hr>
				<a-form-item>
          <div class="header-img-box">
            <span>图片链接</span>
            <span>桥梁总体图片</span>
            <span>图片链接</span>
            <span>桥梁正面图片</span>
          </div>
					<div class="photo-box">
						<a-row justify="space-around" style="height: 100%; align-items: center">
              <a-col>
                <a-input
                    placeholder="图片链接"
                    v-model:value="cardInfo.arr.oal_photo"
                />
              </a-col>
							<a-col :span="6" class="img-input-box">
								<img
										:src="cardInfo.arr.oal_photo.length === 0? defaultImg : cardInfo.arr.oal_photo"
										alt="图片"
								/>
							</a-col>
              <a-col>
                <a-input
                    placeholder="图片链接"
                    v-model:value="cardInfo.arr.frt_photo"
                />
              </a-col>
							<a-col :span="6" class="img-input-box">
								<img
										:src="cardInfo.arr.frt_photo.length === 0? defaultImg : cardInfo.arr.frt_photo"
										alt="图片"
								/>
							</a-col>
						</a-row>
					</div>
					<hr style="margin: 1em auto 1em">
					<table class="basic-card-table">
						<tr style="border-bottom: 1px solid #6c6969">
							<td class="table-item-name">桥梁工程师</td>
							<td class="table-item-content">
								<a-input
										placeholder="桥梁工程师"
										disabled
										v-model:value="initCardData.data.brid_engi"
								/>
							</td>
							<td class="table-item-name">填卡人</td>
							<td class="table-item-content">
								<a-input placeholder="填卡人" v-model:value="cardInfo.arr.card_psn" />
							</td>
							<td class="table-item-name">填卡日期</td>
							<td class="table-item-content">
								<a-date-picker
                    value-format="YYYY-MM-DD"
                    format="YYYY-MM-DD"
                    :locale="locale"
                    class="input-item-default"
                    placeholder="填卡日期"
                    v-model:value="cardInfo.arr.card_time"
                />
							</td>
						</tr>
					</table>
				</a-form-item>
			</a-form>
		</div>
	</a-skeleton>
	<div class="footer-bar" v-if="!loading">
		<a-button
        type="primary"
        style="margin-bottom: 1em"
        @click="submitData"
        :disabled="$route.query.status === 'finish' "
    >
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

</template>

<script lang="ts">
import {defineComponent, reactive, Ref, ref} from 'vue';
import {CloudUploadOutlined, ArrowLeftOutlined} from '@ant-design/icons-vue'
import {useUserStore} from "../../store/user.ts";
import type { SelectProps} from "ant-design-vue";
import axios from "axios";
import { useRoute } from "vue-router";
import { Unit } from '../admin/unit.vue'
import { error_message } from "../../utils/errorMessage.ts";
import locale from "ant-design-vue/lib/time-picker/locale/zh_CN";
import type {Dayjs} from 'dayjs'
const options = ref<SelectProps['options']>([
	{
		value:'全',
		label:'全',
	},
	{
		value:"不全",
		label:'不全',
	},
	{
		value:"无",
		label:'无',
	},
])
export default defineComponent({
	components: {
		CloudUploadOutlined,
		ArrowLeftOutlined,
	},
	setup() {
		let loadingCount = 0
		let loading = ref(true)

		let units: Ref<Unit[]> = ref([])

		const route = useRoute();
		const defaultImg = ref("https://img95.699pic.com/element/40117/2354.png_860.png")
		const techIndex = reactive({
			arr: {
				bridge_wdh:'',
				car_wdh:'',
				psn_wdh:'',
				ctr_dvr_wdh:'',
				pet_hgt:'',
				std_hrm:'',
				act_hrm:'',
				std_trm:'',
				act_trm:'',
				apr_wdh:'',
				crv_rds:'',
				des_fol_lev:'',
				his_fol_lev:'',
				grd_pek_acc:'',
			}
		})
		const cardInfo = reactive({
			arr: {
				bridge_no:route.query.bridge_no,
				oal_photo:'',
				frt_photo:'',
				card_psn:'',
        card_time: ref<Dayjs>(),
				admin_code:'',
				fun_type:'',
				des_load:'',
				bridge_slope:'',
				bridge_radius:'',
				build_time:ref<Dayjs>(),
				otr_sig:'',
			},
			route: {
				route_no:'',
				route_name:'',
				route_rank:'',
				bridge_name:'',
			},
			units: {
				spr_unit:'',
				own_unit:'',
			},
		})
		const bridgeFile = reactive({
			arr: {
				des_draw:'',
				des_file:'',
				fin_draw:'',
				cst_file:'',
				acp_file:'',
				adm_apv_file:'',
				per_chk_info:'',
				spc_chk_info:'',
				hsy_info:'',
				ohr_info:'',
				file_type:'',
				file_time:ref<Dayjs>(),
			},
		})
		const bridgeStruct = reactive({
			arr: [
				{
					struct:"",
					subStruct: [
						{
							subName:'',
							subArr:[
								{
									material:'',
								}
							]
						}
					]
				}
			]
		})
		const assessRecord = reactive({
			arr: [
				{
					ase_rcd_no:'',
					ase_type:"",
					ase_rst:"",
					ctr_mes:"",
					ase_time:"",
					nxt_time:"",
				},
			]
		})
		const maintainRecord = reactive({
			arr: [
				{
					tre_time:"",
					tre_type:"",
					tre_rea:"",
					tre_rge:"",
					pro_fee:"",
					ori_fee:"",
					tre_qlt_aes:"",
				}
			]
		})
		const initCardData = reactive({
			data: {
				bri_len:'初始检查导入，请先完成初始检查',
				cro_name:'初始检查导入，请先完成初始检查',
				cro_no:'初始检查导入，请先完成初始检查',
				bridge_pile:'初始检查导入，请先完成初始检查',
				brid_engi:'初始检查导入，请先完成初始检查',
        des_unit:'初始检查导入，请先完成初始检查',
        cst_unit:'初始检查导入，请先完成初始检查',
			}
		})
		const userStore = useUserStore()
    

		const checkDataFormat = () => {
      if (
					 cardInfo.arr.fun_type == null || cardInfo.arr.fun_type.length === 0 ||
          cardInfo.arr.des_load == null || cardInfo.arr.des_load.length === 0 ||
          cardInfo.arr.bridge_slope == null || cardInfo.arr.bridge_slope.length === 0 ||
          cardInfo.arr.bridge_radius == null || cardInfo.arr.bridge_radius.length === 0 ||
          cardInfo.arr.admin_code == null || cardInfo.arr.admin_code.length === 0
			 ) {
				 error_message( "桥梁行政数据存在部分不合法数据", 'error')
				 return false;
			 }

			 if (
					 techIndex.arr.bridge_wdh == null || techIndex.arr.bridge_wdh.length === 0 ||
					 techIndex.arr.car_wdh == null || techIndex.arr.car_wdh.length === 0 ||
					 techIndex.arr.psn_wdh == null || techIndex.arr.psn_wdh.length === 0 ||
					 techIndex.arr.ctr_dvr_wdh == null || techIndex.arr.ctr_dvr_wdh.length === 0 ||
					 techIndex.arr.pet_hgt == null || techIndex.arr.pet_hgt.length === 0 ||
					 techIndex.arr.std_hrm == null || techIndex.arr.std_hrm.length === 0 ||
					 techIndex.arr.act_hrm == null || techIndex.arr.act_hrm.length === 0 ||
					 techIndex.arr.std_trm == null || techIndex.arr.std_trm.length === 0 ||
					 techIndex.arr.act_trm == null || techIndex.arr.act_trm.length === 0 ||
					 techIndex.arr.apr_wdh == null || techIndex.arr.apr_wdh.length === 0 ||
					 techIndex.arr.crv_rds == null || techIndex.arr.crv_rds.length === 0 ||
					 techIndex.arr.des_fol_lev == null || techIndex.arr.des_fol_lev.length === 0 ||
					 techIndex.arr.his_fol_lev == null || techIndex.arr.his_fol_lev.length === 0 ||
					 techIndex.arr.grd_pek_acc == null || techIndex.arr.grd_pek_acc.length === 0
			 ) {
				 error_message( "桥梁技术指标数据存在部分不合法数据", 'error')
				 return false;
			 }

			 if (
					 cardInfo.units.spr_unit.length === 0 ||
					 cardInfo.units.own_unit.length === 0
			 ) {
				 error_message( "桥面行政数据相关单位必须选择", 'error')
				 return false;
			 }
			 if (
					 bridgeFile.arr.des_draw == null || bridgeFile.arr.des_draw.length === 0 ||
					 bridgeFile.arr.des_file == null || bridgeFile.arr.des_file.length === 0 ||
					 bridgeFile.arr.fin_draw == null || bridgeFile.arr.fin_draw.length === 0 ||
					 bridgeFile.arr.cst_file == null || bridgeFile.arr.cst_file.length === 0 ||
					 bridgeFile.arr.acp_file == null || bridgeFile.arr.acp_file.length === 0 ||
					 bridgeFile.arr.adm_apv_file == null || bridgeFile.arr.adm_apv_file.length === 0 ||
					 bridgeFile.arr.per_chk_info == null || bridgeFile.arr.per_chk_info.length === 0 ||
					 bridgeFile.arr.spc_chk_info == null || bridgeFile.arr.spc_chk_info.length === 0 ||
					 bridgeFile.arr.hsy_info == null || bridgeFile.arr.hsy_info.length === 0 ||
					 bridgeFile.arr.ohr_info == null || bridgeFile.arr.ohr_info.length === 0 ||
					 bridgeFile.arr.file_type == null || bridgeFile.arr.file_type.length === 0
			 ) {
				 error_message( "桥梁档案资料存在不合法数据", 'error')
				 return false;
			 }

			 if (cardInfo.arr.otr_sig == null || cardInfo.arr.otr_sig.length === 0) {
				 error_message("说明事项为空，如确实为空请手动输入空", 'warn')
				 return false;
			 }

			 if (
					 cardInfo.arr.oal_photo == null ||
					 cardInfo.arr.oal_photo.length === 0 ||
					 cardInfo.arr.frt_photo == null ||
					 cardInfo.arr.frt_photo.length === 0
			 ) {
				 error_message("桥梁照片为空", 'error')
				 return false;
			 }

			 if (
					 cardInfo.arr.card_psn == null ||
					 cardInfo.arr.card_psn.length === 0 ||
					 cardInfo.arr.card_time == undefined
			 ) {
				 error_message("请确认填卡人或填卡日期", 'error')
				 return false;
			 }


			 return true
		}


		const submitData = () => {

			if (! checkDataFormat()) return
			else {
				error_message("所有数据合法，正在上传卡片", "success");
			}

      console.log(cardInfo.arr)
      axios({
        url: 'http://localhost:3000/api/basic/card/submit',
        method:'POST',
        params: {
          bridge_no:cardInfo.arr.bridge_no,
          cardInfo:JSON.stringify(cardInfo.arr),
          techIndex:JSON.stringify(techIndex.arr),
          bridgeFile:JSON.stringify(bridgeFile.arr),
          units:JSON.stringify(cardInfo.units),
        }
      }).then((resp) => {
          error_message(resp.data.error_info, resp.data.error_info)
      }).catch(() => {
          error_message("提交失败", "error")
      })

		}


		const getRoute = () => {
			axios({
				url:'http://localhost:3000/api/route/get/bno',
				method:"GET",
				params: {
					bridge_no: route.query.bridge_no
				}
			}).then((resp) => {
				cardInfo.route = resp.data
        loadingCount += 1
			})
		}
		getRoute();

		const getStructInfo = () => {
			axios({
				url: 'http://localhost:3000/api/part/get/info',
				method:'GET',
				params: {
					bridge_no: route.query.bridge_no,
				}
			}).then((resp) => {
				bridgeStruct.arr = resp.data
				loadingCount += 1
			})
		}
		getStructInfo()

		const getUnits = () => {
			axios({
				url: 'http://localhost:3000/api/unit/get/all',
				method:'GET',
			}).then((resp) => {
				units.value = resp.data
				loadingCount += 1
			})
		}
		getUnits()

		const getAssessRecord = () => {
			axios({
				url: 'http://localhost:3000/api/assess/record/get',
				method:'GET',
        params: {
          bridge_no:route.query.bridge_no,
        }
			}).then((resp) => {
				assessRecord.arr = resp.data
				loadingCount += 1
			})
		}
		getAssessRecord();

		const getMaintainRecord = () => {
			axios({
				url: 'http://localhost:3000/api/maintain/record/get',
				method:'GET',
        params: {
          bridge_no:route.query.bridge_no,
        }
			}).then((resp) => {
				maintainRecord.arr = resp.data
				loadingCount += 1
			})
		}
		getMaintainRecord();

    const getCardInfoData = () => {
      axios({
        url: 'http://localhost:3000/api/basic/card/data',
        method:'GET',
        params: {
          bridge_no: route.query.bridge_no
        }
      }).then((resp) => {
        cardInfo.arr = resp.data
        loadingCount += 1
      })
    }
    if(route.query.status === 'finish') getCardInfoData();

    const getTechIndexData = () => {
      axios({
        url: 'http://localhost:3000/api/basic/tech/data',
        method:'GET',
        params: {
          bridge_no: route.query.bridge_no
        }
      }).then((resp) => {
        techIndex.arr = resp.data
        loadingCount += 1
      })
    }
    if(route.query.status === 'finish') getTechIndexData();

    const getBridgeFileData = () => {
      axios({
        url: 'http://localhost:3000/api/basic/file/data',
        method:'GET',
        params: {
          bridge_no: route.query.bridge_no
        }
      }).then((resp) => {
        bridgeFile.arr = resp.data
        loadingCount += 1
      })
    }
    if(route.query.status === 'finish') getBridgeFileData();

    const getUnitJobs = () => {
      axios({
        url: 'http://localhost:3000/api/basic/unitjob/data',
        method:'GET',
        params: {
          bridge_no: route.query.bridge_no
        }
      }).then((resp) => {
        cardInfo.units = resp.data
        loadingCount += 1
      })
    }
    if(route.query.status === 'finish') getUnitJobs();


    const getInitCardData = () => {
      axios({
        url: 'http://localhost:3000/api/basic/initcard/data',
        method:'GET',
        params: {
          bridge_no: route.query.bridge_no
        }
      }).then((resp) => {
        initCardData.data = resp.data
        loadingCount += 1
      })
    }
    if(route.query.initStatus === 'finish') getInitCardData();

		const checkInterval = setInterval(() => {
      let needCount = 5
      if (route.query.status == 'finish') needCount = 9
      if (route.query.initSatus == 'finish') needCount += 1
      if (loadingCount == needCount) {
          loading.value = false
          clearInterval(checkInterval)
			}
		}, 500)




		return {
			loading,
			cardInfo,
			assessRecord,
			userStore,
			bridgeStruct,
			maintainRecord,
			techIndex,
			submitData,
			initCardData,
			bridgeFile,
      locale,
			defaultImg,
			options,
			units,
		}
	}
})

</script>

<style scoped>
.basic-card-container {
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
  align-items: center;
	top: 100px;
	right: 2%;
}
.none-data-tips {
	width: 100%;
	height: 3em;
	font-size: 2em;
	text-align: center;
	line-height: 3em;
	border-bottom: 1px solid #6c6969;
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
	text-align: center;
	width: 100%;
}

.table-item-name {
	width: 10%;
}

.table-item-content {
	width: 20%;
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
h3 {
	margin-bottom: .8em;
}
.input-item-default {
	width: 100%;
}
.photo-box {
	height: 15em;
}

.img-input-box {
  width: 100%;
  display: flex;
  justify-content: center;
  height: 14em;
}
.header-img-box {
  display: flex;
  justify-content: space-around;
}

.header-img-box span {
  margin-right: 3%;
}
.img-input-box img {
  margin-top: 1em;
  height: 12em;
  width: 12em;
}
</style>