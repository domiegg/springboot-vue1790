<template>
	<div class="diy_edit page_disaster_rescue" id="disaster_rescue_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
					<div v-if="$check_field('set','user_number') || $check_field('add','user_number') || $check_field('get','user_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>用户编号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_user_number" :disabled="disabledObj['user_number_isDisabled']" v-model="form['user_number']" v-if="(form['user_number'] && $check_field('set','user_number')) || (!form['user_number'] && $check_field('add','user_number'))" >
								<option v-for="o in list_user_user_number" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','user_number')">{{ form['user_number'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>用户姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"  :disabled="disabledObj['user_name_isDisabled']"/>
							<span v-else-if="$check_field('get','user_name')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','contact_information') || $check_field('add','contact_information') || $check_field('get','contact_information')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>联系方式:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_contact_information" v-model="form['contact_information']" placeholder="请输入联系方式" v-if="(form['contact_information'] && $check_field('set','contact_information')) || (!form['contact_information'] && $check_field('add','contact_information'))"  :disabled="disabledObj['contact_information_isDisabled']"/>
							<span v-else-if="$check_field('get','contact_information')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','id') || $check_field('add','id') || $check_field('get','id')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>身份证:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_id" v-model="form['id']" placeholder="请输入身份证" v-if="(form['id'] && $check_field('set','id')) || (!form['id'] && $check_field('add','id'))"  :disabled="disabledObj['id_isDisabled']"/>
							<span v-else-if="$check_field('get','id')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','disaster_address') || $check_field('add','disaster_address') || $check_field('get','disaster_address')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>灾情地址:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_disaster_address" v-model="form['disaster_address']" placeholder="请输入灾情地址" v-if="(form['disaster_address'] && $check_field('set','disaster_address')) || (!form['disaster_address'] && $check_field('add','disaster_address'))"  :disabled="disabledObj['disaster_address_isDisabled']"/>
							<span v-else-if="$check_field('get','disaster_address')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','disaster_type') || $check_field('add','disaster_type') || $check_field('get','disaster_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>灾情类型:
							</span>
						</div>
						<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_disaster_type" v-model="form['disaster_type']" v-if="(form['disaster_type'] && $check_field('set','disaster_type')) || (!form['disaster_type'] && $check_field('add','disaster_type'))" >
								<option v-for="o in list_disaster_type" :value="o['disaster_type']">
									{{ o['disaster_type'] }}
								</option>
							</select>
							<span v-else-if="$check_field('get','disaster_type')">{{ form['disaster_type'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','apply_for_materials') || $check_field('add','apply_for_materials') || $check_field('get','apply_for_materials')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>申请物资:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_apply_for_materials" v-model="form['apply_for_materials']" placeholder="请输入申请物资" v-if="(form['apply_for_materials'] && $check_field('set','apply_for_materials')) || (!form['apply_for_materials'] && $check_field('add','apply_for_materials'))"  :disabled="disabledObj['apply_for_materials_isDisabled']"/>
							<span v-else-if="$check_field('get','apply_for_materials')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','material_type') || $check_field('add','material_type') || $check_field('get','material_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>物资类型:
							</span>
						</div>
						<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_material_type" v-model="form['material_type']" v-if="(form['material_type'] && $check_field('set','material_type')) || (!form['material_type'] && $check_field('add','material_type'))" >
								<option v-for="o in list_material_type" :value="o['material_type']">
									{{ o['material_type'] }}
								</option>
							</select>
							<span v-else-if="$check_field('get','material_type')">{{ form['material_type'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','application_time') || $check_field('add','application_time') || $check_field('get','application_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>申请时间:
							</span>
						</div>
						<!-- 日期 -->
						<div class="diy_field diy_date">
							<input type="date" :disabled="disabledObj['application_time_isDisabled']" id="form_application_time" v-model="form['application_time']" placeholder="请输入申请时间" v-if="(form['application_time'] && $check_field('set','application_time')) || (!form['application_time'] && $check_field('add','application_time'))" />
							<span v-else-if="$check_field('get','application_time')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','disaster_situation') || $check_field('add','disaster_situation') || $check_field('get','disaster_situation')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>灾情情况:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_disaster_situation" v-model="form['disaster_situation']" v-if="(form['disaster_situation'] && $check_field('set','disaster_situation')) || (!form['disaster_situation'] && $check_field('add','disaster_situation'))" :disabled="disabledObj['disaster_situation_isDisabled']" />
							<span v-else-if="$check_field('get','disaster_situation')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','application_content') || $check_field('add','application_content') || $check_field('get','application_content')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>申请内容:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_application_content" v-model="form['application_content']" v-if="(form['application_content'] && $check_field('set','application_content')) || (!form['application_content'] && $check_field('add','application_content'))" :disabled="disabledObj['application_content_isDisabled']" />
							<span v-else-if="$check_field('get','application_content')">{{ form['user_name'] }}</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/disaster_rescue/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/disaster_rescue/get_obj?",
				url_add: "~/api/disaster_rescue/add?",
				url_set: "~/api/disaster_rescue/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"user_number": 0,
					"user_name": "",
					"contact_information": "",
					"id": "",
					"disaster_address": "",
					"disaster_type": "",
					"apply_for_materials": "",
					"material_type": "",
					"application_time": "",
					"disaster_situation": "",
					"application_content": "",
					"disaster_rescue_id": 0,
				},

				obj: {
					"user_number": 0, // 用户编号
					"user_name":'', // 用户姓名
					"contact_information":'', // 联系方式
					"id":'', // 身份证
					"disaster_address":'', // 灾情地址
					"disaster_type":'', // 灾情类型
					"apply_for_materials":'', // 申请物资
					"material_type":'', // 物资类型
					"application_time": new Date().getTime(),
					"disaster_situation":'', // 灾情情况
					"application_content":'', // 申请内容
					"examine_state": "未审核",
					"disaster_rescue_id": 0,
				},

				// 表单字段
				form: {
					"user_number": 0, // 用户编号
					"user_name":'', // 用户姓名
					"contact_information":'', // 联系方式
					"id":'', // 身份证
					"disaster_address":'', // 灾情地址
					"disaster_type":'', // 灾情类型
					"apply_for_materials":'', // 申请物资
					"material_type":'', // 物资类型
					"application_time": new Date().getTime(),
					"disaster_situation":'', // 灾情情况
					"application_content":'', // 申请内容
					"examine_state": "未审核",
					"disaster_rescue_id": 0,
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
				//灾情类型选项列表
				list_disaster_type: [],
				//物资类型选项列表
				list_material_type: [],

				// ID字段
				field: "disaster_rescue_id",
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
			async get_user_session_user_number(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["user_number"] = user_id
								_this.disabledObj['user_number' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "user_number") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
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
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/disaster_rescue/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
        if (JSON.stringify(this.form["application_time"]).indexOf("-")===-1) {
          this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]), "yyyy-MM-dd")
        }
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (obj) {
          delete(obj.examine_state)
          delete(obj.examine_reply)
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
          delete(form.examine_state)
          delete(form.examine_reply)
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_user_session_user_number();
			this.get_list_user_user_number();
			this.get_list_disaster_type();
			this.get_list_material_type();
		},
	}
</script>

<style>
</style>
