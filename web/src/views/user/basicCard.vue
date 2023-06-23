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
								<a-input placeholder="桥梁所属行政区代码" />
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
								<a-input placeholder="路线编号" />
							</td>
							<td class="table-item-name">路线名称</td>
							<td class="table-item-content">
								<a-input placeholder="路线编号" />
							</td>
							<td class="table-item-name">路线等级</td>
							<td class="table-item-content">
								<a-input placeholder="路线编号" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥梁编号</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁编号" />
							</td>
							<td class="table-item-name">桥梁名称</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁名称" />
							</td>
							<td class="table-item-name">桥位桩号</td>
							<td class="table-item-content">
								<a-input  placeholder="桥位桩号" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">功能类型</td>
							<td class="table-item-content">
								<a-input placeholder="功能类型" />
							</td>
							<td class="table-item-name">被跨越道路名称</td>
							<td class="table-item-content">
								<a-input placeholder="被跨越道路名称" />
							</td>
							<td class="table-item-name">被跨越道路桩号</td>
							<td class="table-item-content">
								<a-input placeholder="被跨越道路桩号" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">设计载荷</td>
							<td class="table-item-content">
								<a-input placeholder="设计载荷" />
							</td>
							<td class="table-item-name">桥梁坡度</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁坡度" />
							</td>
							<td class="table-item-name">桥梁平曲线半径</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁平曲线半径" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">建成时间</td>
							<td class="table-item-content">
								<a-input placeholder="建成时间" />
							</td>
							<td class="table-item-name">设计单位</td>
							<td class="table-item-content">
								<a-input placeholder="设计单位" />
							</td>
							<td class="table-item-name">施工单位</td>
							<td class="table-item-content">
								<a-input placeholder="施工单位" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">监理单位</td>
							<td class="table-item-content">
								<a-input placeholder="监理单位" />
							</td>
							<td class="table-item-name">业主单位</td>
							<td class="table-item-content">
								<a-input placeholder="业主单位" />
							</td>
							<td class="table-item-name">管养单位</td>
							<td class="table-item-content">
								<a-input placeholder="管养单位" />
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
								<a-input placeholder="桥梁全长" />
							</td>
							<td class="table-item-name">桥面总宽</td>
							<td class="table-item-content">
								<a-input placeholder="桥面总宽" />
							</td>
							<td class="table-item-name">车道宽度</td>
							<td class="table-item-content">
								<a-input placeholder="车道宽度" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">人行道宽度</td>
							<td class="table-item-content">
								<a-input placeholder="人行道宽度" />
							</td>
							<td class="table-item-name">护栏或防撞墙高度</td>
							<td class="table-item-content">
								<a-input placeholder="护栏或防撞墙高度" />
							</td>
							<td class="table-item-name">中央分隔带高度</td>
							<td class="table-item-content">
								<a-input placeholder="中央分隔带高度" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥面标准净空</td>
							<td class="table-item-content">
								<a-input placeholder="桥面标准净空" />
							</td>
							<td class="table-item-name">桥面实际净空</td>
							<td class="table-item-content">
								<a-input placeholder="桥面实际净空" />
							</td>
							<td class="table-item-name">桥下通航等级及标准净空</td>
							<td class="table-item-content">
								<a-input placeholder="桥下通航等级及标准净空" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">桥下实际净空</td>
							<td class="table-item-content">
								<a-input placeholder="桥下实际净空" />
							</td>
							<td class="table-item-name">引道总宽</td>
							<td class="table-item-content">
								<a-input placeholder="引道总宽" />
							</td>
							<td class="table-item-name">引道线形或曲线半径</td>
							<td class="table-item-content">
								<a-input placeholder="引道线形或曲线半径" />
							</td>
						</tr>
						<tr>
							<td class="table-item-name">设计洪水频率及其水位</td>
							<td class="table-item-content">
								<a-input placeholder="设计洪水频率及其水位" />
							</td>
							<td class="table-item-name">历史洪水位</td>
							<td class="table-item-content">
								<a-input placeholder="历史洪水位" />
							</td>
							<td class="table-item-name">设计地震动峰值加速度系数</td>
							<td class="table-item-content">
								<a-input placeholder="设计地震动峰值加速度系数" />
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
							<td class="table-item-name">设计图纸</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">设计文件</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">竣工图纸</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">施工文件</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">验收文件</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">行政审批文件</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">定期检查资料</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">特殊检查资料</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
							<td class="table-item-name">历次维修、加固资料</td>
							<td class="table-item-content">
								<a-select :options="options"></a-select>
							</td>
						</tr>
						<tr>
							<td class="table-item-name">其他档案</td>
							<td class="table-item-content">
								<a-input placeholder="其他档案" />
							</td>
							<td class="table-item-name">档案形式</td>
							<td class="table-item-content">
								<a-select ref="select">
									<a-select-option value="电子档案">电子档案</a-select-option>
									<a-select-option value="纸质档案">纸质档案</a-select-option>
								</a-select>
							</td>
							<td class="table-item-name">建档时间</td>
							<td class="table-item-content">
								<a-input placeholder="建档时间" />
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
							<th>建设单位</th>
							<th>设计单位</th>
							<th>施工单位</th>
							<th>监理单位</th>
						</tr>
						<tr v-for="item in maintainRecord.arr" class="assess-record-tr">
							<td> {{ item.tre_time }} </td>
							<td> {{ item.tre_type }} </td>
							<td> {{ item.tre_rea }} </td>
							<td> {{ item.tre_rge }} </td>
							<td> {{ item.pro_fee }} </td>
							<td> {{ item.ori_fee }} </td>
							<td> {{ item.tre_qlt_aes }} </td>
							<td> {{ item.bid_unit }} </td>
							<td> {{ item.dsn_unit }} </td>
							<td> {{ item.gh_unit }} </td>
							<td> {{ item.look_unit }} </td>
						</tr>
					</table>
				</a-form-item>
				<h3>说明事项（文本框）</h3>
				<hr>
				<a-form-item>
					<a-textarea
							v-model:value="otr_sig"
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

					<div class="photo-box">
						<a-row justify="space-around" style="height: 100%; align-items: center">
							<a-col :span="1" style="writing-mode: vertical-lr; ">
								桥梁总体图片
							</a-col>
							<a-col :span="8">
								<a-input placeholder="路线编号" v-model:value="img1" style="width: 10em; margin-right: 2em" />
								<img :src="img2" alt="图片" style="height: 10em; margin: 1em auto 0;"/>
							</a-col>
							<a-col :span="1" style="writing-mode: vertical-lr; ">
								桥梁正面图片
							</a-col>
							<a-col :span="8">
								<a-input placeholder="路线编号" v-model:value="img2" style="width: 10em; margin-right: 2em" />
								<img :src="img2" alt="图片" style="height: 10em; margin: 1em auto 0;"/>
							</a-col>
						</a-row>
					</div>
					<hr style="margin: 1em auto 1em">
					<table class="basic-card-table">
						<tr style="border-bottom: 1px solid #6c6969">
							<td class="table-item-name">桥梁工程师</td>
							<td class="table-item-content">
								<a-input placeholder="桥梁工程师" />
							</td>
							<td class="table-item-name">填卡人</td>
							<td class="table-item-content">
								<a-input placeholder="填卡人" />
							</td>
							<td class="table-item-name">填卡日期</td>
							<td class="table-item-content">
								<a-input placeholder="填卡日期" />
							</td>
						</tr>
					</table>
				</a-form-item>
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

</template>

<script lang="ts">
import {defineComponent, reactive, ref} from 'vue';
import {CloudUploadOutlined, ArrowLeftOutlined} from '@ant-design/icons-vue'
import {useUserStore} from "../../store/user.ts";
import type {SelectProps} from "ant-design-vue";

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

		const assessRecord = reactive({
			arr: [
				{
					ase_rcd_no:'001',
					ase_type:"好类型",
					ase_rst:"结果......",
					ctr_mes:"处治对策",
					ase_time:"2023-6-22",
					nxt_time:"2024-6-22",
				},{
					ase_rcd_no:'002',
					ase_type:"好类型",
					ase_rst:"结果......",
					ctr_mes:"处治对策",
					ase_time:"2023-6-22",
					nxt_time:"2024-6-22",
				},{
					ase_rcd_no:'003',
					ase_type:"好类型",
					ase_rst:"结果......",
					ctr_mes:"处治对策",
					ase_time:"2023-6-22",
					nxt_time:"2024-6-22",
				},{
					ase_rcd_no:'004',
					ase_type:"好类型",
					ase_rst:"结果......",
					ctr_mes:"处治对策",
					ase_time:"2023-6-22",
					nxt_time:"2024-6-22",
				},
			]
		})

		let img1 = ref('https://picnew14.photophoto.cn/20200727/huisediwenbeijingtupian-38236152_1.jpg')
		let img2 = ref('https://picnew14.photophoto.cn/20200727/huisediwenbeijingtupian-38236152_1.jpg')

		const userStore = useUserStore()

		const otr_sig = ref<string>("无")

		const maintainRecord = reactive({
			arr: [
				{
					tre_time:"2023-6-22",
					tre_type:"处治类别",
					tre_rea:"处治原因",
					tre_rge:"处治范围",
					pro_fee:"工程费用",
					ori_fee:"费用来源",
					tre_qlt_aes:"处治质量评定",
					bid_unit:"建设单位",
					dsn_unit:"设计单位",
					gh_unit:"施工单位",
					look_unit:"监理单位",
				},{
					tre_time:"2023-6-22",
					tre_type:"处治类别",
					tre_rea:"处治原因",
					tre_rge:"处治范围",
					pro_fee:"工程费用",
					ori_fee:"费用来源",
					tre_qlt_aes:"处治质量评定",
					bid_unit:"建设单位",
					dsn_unit:"设计单位",
					gh_unit:"施工单位",
					look_unit:"监理单位",
				},{
					tre_time:"2023-6-22",
					tre_type:"处治类别",
					tre_rea:"处治原因",
					tre_rge:"处治范围",
					pro_fee:"工程费用",
					ori_fee:"费用来源",
					tre_qlt_aes:"处治质量评定",
					bid_unit:"建设单位",
					dsn_unit:"设计单位",
					gh_unit:"施工单位",
					look_unit:"监理单位",
				},
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
			assessRecord,
			otr_sig,
			userStore,
			bridgeStruct,
			maintainRecord,
			options,
			img1,
			img2,
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

.photo-box {
	height: 15em;
}
</style>