<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','material_name') || $check_field('add','material_name') || $check_field('set','material_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资名称" prop="material_name">
					<el-input id="material_name" v-model="form['material_name']" placeholder="请输入物资名称"
							  v-if="user_group === '管理员' || (form['material_management_id'] && $check_field('set','material_name')) || (!form['material_management_id'] && $check_field('add','material_name'))" :disabled="disabledObj['material_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_name')">{{form['material_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_type') || $check_field('add','material_type') || $check_field('set','material_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类型" prop="material_type">
					<el-select id="material_type" v-model="form['material_type']"
						v-if="user_group === '管理员' || (form['material_management_id'] && $check_field('set','material_type')) || (!form['material_management_id'] && $check_field('add','material_type'))">
						<el-option v-for="o in list_material_type" :key="o['material_type']" :label="o['material_type']"
							:value="o['material_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','material_type')">{{form['material_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','quantity_of_materials') || $check_field('add','quantity_of_materials') || $check_field('set','quantity_of_materials')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资数量" prop="quantity_of_materials">
					<el-input id="quantity_of_materials" v-model="form['quantity_of_materials']" placeholder="请输入物资数量"
							  v-if="user_group === '管理员' || (form['material_management_id'] && $check_field('set','quantity_of_materials')) || (!form['material_management_id'] && $check_field('add','quantity_of_materials'))" :disabled="disabledObj['quantity_of_materials_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','quantity_of_materials')">{{form['quantity_of_materials']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_picture') || $check_field('add','material_picture') || $check_field('set','material_picture')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资图片" prop="material_picture">
					<el-upload :disabled="disabledObj['material_picture_isDisabled']" id="material_picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_material_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['material_management_id'] && $check_field('set','material_picture')) || (!form['material_management_id'] && $check_field('add','material_picture'))">
						<img v-if="form['material_picture']" :src="$fullUrl(form['material_picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','material_picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['material_picture'])" :preview-src-list="[$fullUrl(form['material_picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_introduction') || $check_field('add','material_introduction') || $check_field('set','material_introduction')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资简介" prop="material_introduction">
					<el-input type="textarea" id="material_introduction" v-model="form['material_introduction']" placeholder="请输入物资简介"
						v-if="user_group === '管理员' || (form['material_management_id'] && $check_field('set','material_introduction')) || (!form['material_management_id'] && $check_field('add','material_introduction'))" :disabled="disabledObj['material_introduction_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_introduction')">{{form['material_introduction']}}</div>
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
				field: "material_management_id",
				url_add: "~/api/material_management/add?",
				url_set: "~/api/material_management/set?",
				url_get_obj: "~/api/material_management/get_obj?",
				url_upload: "~/api/material_management/upload?",

				query: {
					"material_management_id": 0,
				},

				form: {
					"material_name":'', // 物资名称
					"material_type":'', // 物资类型
					"quantity_of_materials":'', // 物资数量
					"material_picture":'', // 物资图片
					"material_introduction":'', // 物资简介
					"material_management_id": 0, // ID

				},
				disabledObj:{
					"material_name_isDisabled": false,
					"material_type_isDisabled": false,
					"quantity_of_materials_isDisabled": false,
					"material_picture_isDisabled": false,
					"material_introduction_isDisabled": false,
				},
				//物资类型选项列表
				list_material_type: [],
			}
		},
		methods: {
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
			 * 上传物资图片
			 * @param {Object} param图片参数
			 */
			upload_material_picture(param){
				this.uploadFile(param.file, "material_picture");
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
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/material_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_management/view','get');
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
