<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
						<el-select v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','user_number')) || (!form['rescue_plan_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user_number')" id="user_number" v-model="form['user_number']" :disabled="true">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
					<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','user_name')) || (!form['rescue_plan_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
					<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','contact_information')) || (!form['rescue_plan_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','id')) || (!form['rescue_plan_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_address') || $check_field('add','disaster_address') || $check_field('set','disaster_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情地址" prop="disaster_address">
					<el-input id="disaster_address" v-model="form['disaster_address']" placeholder="请输入灾情地址"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','disaster_address')) || (!form['rescue_plan_id'] && $check_field('add','disaster_address'))" :disabled="disabledObj['disaster_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disaster_address')">{{form['disaster_address']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_type') || $check_field('add','disaster_type') || $check_field('set','disaster_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情类型" prop="disaster_type">
					<el-input id="disaster_type" v-model="form['disaster_type']" placeholder="请输入灾情类型"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','disaster_type')) || (!form['rescue_plan_id'] && $check_field('add','disaster_type'))" :disabled="disabledObj['disaster_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disaster_type')">{{form['disaster_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','apply_for_materials') || $check_field('add','apply_for_materials') || $check_field('set','apply_for_materials')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请物资" prop="apply_for_materials">
					<el-input id="apply_for_materials" v-model="form['apply_for_materials']" placeholder="请输入申请物资"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','apply_for_materials')) || (!form['rescue_plan_id'] && $check_field('add','apply_for_materials'))" :disabled="disabledObj['apply_for_materials_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','apply_for_materials')">{{form['apply_for_materials']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_type') || $check_field('add','material_type') || $check_field('set','material_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类型" prop="material_type">
					<el-input id="material_type" v-model="form['material_type']" placeholder="请输入物资类型"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','material_type')) || (!form['rescue_plan_id'] && $check_field('add','material_type'))" :disabled="disabledObj['material_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_type')">{{form['material_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','application_time') || $check_field('add','application_time') || $check_field('set','application_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请时间" prop="application_time">
					<el-date-picker :disabled="disabledObj['application_time_isDisabled']" v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','application_time')) || (!form['rescue_plan_id'] && $check_field('add','application_time'))" id="application_time"
						v-model="form['application_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','application_time')">{{form['application_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','plan_name') || $check_field('add','plan_name') || $check_field('set','plan_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="计划名称" prop="plan_name">
					<el-input id="plan_name" v-model="form['plan_name']" placeholder="请输入计划名称"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','plan_name')) || (!form['rescue_plan_id'] && $check_field('add','plan_name'))" :disabled="disabledObj['plan_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','plan_name')">{{form['plan_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','plan_type') || $check_field('add','plan_type') || $check_field('set','plan_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="计划类型" prop="plan_type">
					<el-input id="plan_type" v-model="form['plan_type']" placeholder="请输入计划类型"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','plan_type')) || (!form['rescue_plan_id'] && $check_field('add','plan_type'))" :disabled="disabledObj['plan_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','plan_type')">{{form['plan_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','degree_of_urgency') || $check_field('add','degree_of_urgency') || $check_field('set','degree_of_urgency')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="紧急程度" prop="degree_of_urgency">
					<el-input id="degree_of_urgency" v-model="form['degree_of_urgency']" placeholder="请输入紧急程度"
							  v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','degree_of_urgency')) || (!form['rescue_plan_id'] && $check_field('add','degree_of_urgency'))" :disabled="disabledObj['degree_of_urgency_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','degree_of_urgency')">{{form['degree_of_urgency']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','estimated_rescue_time') || $check_field('add','estimated_rescue_time') || $check_field('set','estimated_rescue_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预计救援时间" prop="estimated_rescue_time">
					<el-date-picker :disabled="disabledObj['estimated_rescue_time_isDisabled']" v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','estimated_rescue_time')) || (!form['rescue_plan_id'] && $check_field('add','estimated_rescue_time'))" id="estimated_rescue_time"
						v-model="form['estimated_rescue_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','estimated_rescue_time')">{{form['estimated_rescue_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_situation') || $check_field('add','disaster_situation') || $check_field('set','disaster_situation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情情况" prop="disaster_situation">
					<el-input type="textarea" id="disaster_situation" v-model="form['disaster_situation']" placeholder="请输入灾情情况"
						v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','disaster_situation')) || (!form['rescue_plan_id'] && $check_field('add','disaster_situation'))" :disabled="disabledObj['disaster_situation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disaster_situation')">{{form['disaster_situation']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','application_content') || $check_field('add','application_content') || $check_field('set','application_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请内容" prop="application_content">
					<el-input type="textarea" id="application_content" v-model="form['application_content']" placeholder="请输入申请内容"
						v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','application_content')) || (!form['rescue_plan_id'] && $check_field('add','application_content'))" :disabled="disabledObj['application_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','application_content')">{{form['application_content']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','plan_content') || $check_field('add','plan_content') || $check_field('set','plan_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="计划内容" prop="plan_content">
					<el-input type="textarea" id="plan_content" v-model="form['plan_content']" placeholder="请输入计划内容"
						v-if="user_group === '管理员' || (form['rescue_plan_id'] && $check_field('set','plan_content')) || (!form['rescue_plan_id'] && $check_field('add','plan_content'))" :disabled="disabledObj['plan_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','plan_content')">{{form['plan_content']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "rescue_plan_id",
				url_add: "~/api/rescue_plan/add?",
				url_set: "~/api/rescue_plan/set?",
				url_get_obj: "~/api/rescue_plan/get_obj?",
				url_upload: "~/api/rescue_plan/upload?",

				query: {
					"rescue_plan_id": 0,
				},

				form: {
					"user_number": 0, // 用户编号
					"user_name":'', // 用户姓名
					"contact_information":'', // 联系方式
					"id":'', // 身份证
					"disaster_address":'', // 灾情地址
					"disaster_type":'', // 灾情类型
					"apply_for_materials":'', // 申请物资
					"material_type":'', // 物资类型
					"application_time":'', // 申请时间
					"plan_name":'', // 计划名称
					"plan_type":'', // 计划类型
					"degree_of_urgency":'', // 紧急程度
					"estimated_rescue_time":'', // 预计救援时间
					"disaster_situation":'', // 灾情情况
					"application_content":'', // 申请内容
					"plan_content":'', // 计划内容
					"rescue_plan_id": 0, // ID

				},
				disabledObj:{
					"user_number_isDisabled": false,
					"user_name_isDisabled": false,
					"contact_information_isDisabled": false,
					"id_isDisabled": false,
					"disaster_address_isDisabled": false,
					"disaster_type_isDisabled": false,
					"apply_for_materials_isDisabled": false,
					"material_type_isDisabled": false,
					"application_time_isDisabled": false,
					"plan_name_isDisabled": false,
					"plan_type_isDisabled": false,
					"degree_of_urgency_isDisabled": false,
					"estimated_rescue_time_isDisabled": false,
					"disaster_situation_isDisabled": false,
					"application_content_isDisabled": false,
					"plan_content_isDisabled": false,
				},
				// 用户列表
				list_user_user_number: [],
			}
		},
		methods: {
			/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_user_number() {
                // if(this.user_group !== "管理员" && this.form["user_number"] === 0) {
                //     this.form["user_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_user_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_user_number(id){
				var obj = this.list_user_user_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "用户编号":
							if(param["user_number"] > 0){
								param["user_number"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
        if (this.form["application_time"].indexOf("-")===-1){
          this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]),"yyyy-MM-dd")
        }
        if (this.form["estimated_rescue_time"].indexOf("-")===-1){
          this.form["estimated_rescue_time"] = this.$toTime(parseInt(this.form["estimated_rescue_time"]),"yyyy-MM-dd")
        }
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
        if(this.form["application_time"]=="0000-00-00"){
          this.form["application_time"] = null;
        }
				if(parseInt(this.form["application_time"]) > 9999){
					this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]),"yyyy-MM-dd")
				}
        if(this.form["estimated_rescue_time"]=="0000-00-00"){
          this.form["estimated_rescue_time"] = null;
        }
				if(parseInt(this.form["estimated_rescue_time"]) > 9999){
					this.form["estimated_rescue_time"] = this.$toTime(parseInt(this.form["estimated_rescue_time"]),"yyyy-MM-dd")
				}
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/rescue_plan/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_plan/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_plan/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_plan/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/rescue_plan/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_user_number();
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
