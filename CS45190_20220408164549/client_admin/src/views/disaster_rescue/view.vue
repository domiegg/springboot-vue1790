<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','user_number') || $check_field('add','user_number') || $check_field('set','user_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户编号" prop="user_number">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_number(form['user_number']) }}
							<!--<el-input id="business_name" v-model="form['user_number']" placeholder="请输入用户编号"-->
							<!--v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','user_number')) || (!form['disaster_rescue_id'] && $check_field('add','user_number'))" :disabled="disabledObj['user_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_number')">{{form['user_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','user_number')) || (!form['disaster_rescue_id'] && $check_field('add','user_number'))" id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_number')" id="user_number" v-model="form['user_number']" :disabled="true">
								<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_number" v-model="form['user_number']" :disabled="disabledObj['user_number_isDisabled']">
							<el-option v-for="o in list_user_user_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
					<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','user_name')) || (!form['disaster_rescue_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
					<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','contact_information')) || (!form['disaster_rescue_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','id')) || (!form['disaster_rescue_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_address') || $check_field('add','disaster_address') || $check_field('set','disaster_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情地址" prop="disaster_address">
					<el-input id="disaster_address" v-model="form['disaster_address']" placeholder="请输入灾情地址"
							  v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','disaster_address')) || (!form['disaster_rescue_id'] && $check_field('add','disaster_address'))" :disabled="disabledObj['disaster_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disaster_address')">{{form['disaster_address']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_type') || $check_field('add','disaster_type') || $check_field('set','disaster_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情类型" prop="disaster_type">
					<el-select id="disaster_type" v-model="form['disaster_type']"
						v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','disaster_type')) || (!form['disaster_rescue_id'] && $check_field('add','disaster_type'))">
						<el-option v-for="o in list_disaster_type" :key="o['disaster_type']" :label="o['disaster_type']"
							:value="o['disaster_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','disaster_type')">{{form['disaster_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','apply_for_materials') || $check_field('add','apply_for_materials') || $check_field('set','apply_for_materials')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请物资" prop="apply_for_materials">
					<el-input id="apply_for_materials" v-model="form['apply_for_materials']" placeholder="请输入申请物资"
							  v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','apply_for_materials')) || (!form['disaster_rescue_id'] && $check_field('add','apply_for_materials'))" :disabled="disabledObj['apply_for_materials_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','apply_for_materials')">{{form['apply_for_materials']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_type') || $check_field('add','material_type') || $check_field('set','material_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类型" prop="material_type">
					<el-select id="material_type" v-model="form['material_type']"
						v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','material_type')) || (!form['disaster_rescue_id'] && $check_field('add','material_type'))">
						<el-option v-for="o in list_material_type" :key="o['material_type']" :label="o['material_type']"
							:value="o['material_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','material_type')">{{form['material_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','application_time') || $check_field('add','application_time') || $check_field('set','application_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请时间" prop="application_time">
					<el-date-picker :disabled="disabledObj['application_time_isDisabled']" v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','application_time')) || (!form['disaster_rescue_id'] && $check_field('add','application_time'))" id="application_time"
						v-model="form['application_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','application_time')">{{form['application_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disaster_situation') || $check_field('add','disaster_situation') || $check_field('set','disaster_situation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="灾情情况" prop="disaster_situation">
					<el-input type="textarea" id="disaster_situation" v-model="form['disaster_situation']" placeholder="请输入灾情情况"
						v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','disaster_situation')) || (!form['disaster_rescue_id'] && $check_field('add','disaster_situation'))" :disabled="disabledObj['disaster_situation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disaster_situation')">{{form['disaster_situation']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','application_content') || $check_field('add','application_content') || $check_field('set','application_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请内容" prop="application_content">
					<el-input type="textarea" id="application_content" v-model="form['application_content']" placeholder="请输入申请内容"
						v-if="user_group === '管理员' || (form['disaster_rescue_id'] && $check_field('set','application_content')) || (!form['disaster_rescue_id'] && $check_field('add','application_content'))" :disabled="disabledObj['application_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','application_content')">{{form['application_content']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
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
				field: "disaster_rescue_id",
				url_add: "~/api/disaster_rescue/add?",
				url_set: "~/api/disaster_rescue/set?",
				url_get_obj: "~/api/disaster_rescue/get_obj?",
				url_upload: "~/api/disaster_rescue/upload?",

				query: {
					"disaster_rescue_id": 0,
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
					"disaster_situation":'', // 灾情情况
					"application_content":'', // 申请内容
					"examine_state": "未审核",
					"disaster_rescue_id": 0, // ID

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
					"disaster_situation_isDisabled": false,
					"application_content_isDisabled": false,
				},
				// 用户列表
				list_user_user_number: [],
				// 用户组
				group_user_user_number: "",
				//灾情类型选项列表
				list_disaster_type: [],
				//物资类型选项列表
				list_material_type: [],
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
			/**
			 * 获取普通用户用户组
			 */
			async get_group_user_user_number() {
				this.form["user_number"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					this.group_user_user_number = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_number(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_number.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                for (var j = 0; j < arrForm.length; j++) {
                  if (arr[i] === arrForm[j]) {
                    if (arr[i] !== "user_number") {
                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                      break;
                    } else {
                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    }
                  }
                }
              }
						}
					}
				});
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
			 * 获取灾情类型列表
			 */
			async get_list_disaster_type() {
				var json = await this.$get("~/api/disaster_classification/get_list?");
				if(json.result && json.result.list){
					this.list_disaster_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			/**
			 * 获取物资类型列表
			 */
			async get_list_material_type() {
				var json = await this.$get("~/api/material_classification/get_list?");
				if(json.result && json.result.list){
					this.list_material_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
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
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/disaster_rescue/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/disaster_rescue/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/disaster_rescue/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/disaster_rescue/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/disaster_rescue/view','get');
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
			this.get_group_user_user_number();
			this.get_list_disaster_type();
			this.get_list_material_type();
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
