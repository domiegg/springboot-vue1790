<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','material_name') || $check_field('add','material_name') || $check_field('set','material_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资名称" prop="material_name">
					<el-input id="material_name" v-model="form['material_name']" placeholder="请输入物资名称"
							  v-if="user_group === '管理员' || (form['material_inventory_id'] && $check_field('set','material_name')) || (!form['material_inventory_id'] && $check_field('add','material_name'))" :disabled="disabledObj['material_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_name')">{{form['material_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_type') || $check_field('add','material_type') || $check_field('set','material_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类型" prop="material_type">
					<el-select id="material_type" v-model="form['material_type']"
						v-if="user_group === '管理员' || (form['material_inventory_id'] && $check_field('set','material_type')) || (!form['material_inventory_id'] && $check_field('add','material_type'))">
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
							  v-if="user_group === '管理员' || (form['material_inventory_id'] && $check_field('set','quantity_of_materials')) || (!form['material_inventory_id'] && $check_field('add','quantity_of_materials'))" :disabled="disabledObj['quantity_of_materials_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','quantity_of_materials')">{{form['quantity_of_materials']}}</div>
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
				field: "material_inventory_id",
				url_add: "~/api/material_inventory/add?",
				url_set: "~/api/material_inventory/set?",
				url_get_obj: "~/api/material_inventory/get_obj?",
				url_upload: "~/api/material_inventory/upload?",

				query: {
					"material_inventory_id": 0,
				},

				form: {
					"material_name":'', // 物资名称
					"material_type":'', // 物资类型
					"quantity_of_materials":'', // 物资数量
					"material_inventory_id": 0, // ID

				},
				disabledObj:{
					"material_name_isDisabled": false,
					"material_type_isDisabled": false,
					"quantity_of_materials_isDisabled": false,
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
					bl = this.$check_action('/material_inventory/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_inventory/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_inventory/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material_inventory/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material_inventory/view','get');
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
