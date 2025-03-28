<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','material_name') || $check_field('add','material_name') || $check_field('set','material_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资名称" prop="material_name">
					<el-input id="material_name" v-model="form['material_name']" placeholder="请输入物资名称"
							  v-if="user_group === '管理员' || (form['material_id'] && $check_field('set','material_name')) || (!form['material_id'] && $check_field('add','material_name'))" :disabled="disabledObj['material_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_name')">{{form['material_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_type') || $check_field('add','material_type') || $check_field('set','material_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资类型" prop="material_type">
					<el-input id="material_type" v-model="form['material_type']" placeholder="请输入物资类型"
							  v-if="user_group === '管理员' || (form['material_id'] && $check_field('set','material_type')) || (!form['material_id'] && $check_field('add','material_type'))" :disabled="disabledObj['material_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_type')">{{form['material_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','receipt_quantity') || $check_field('add','receipt_quantity') || $check_field('set','receipt_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库数量" prop="receipt_quantity">
					<el-input-number id="receipt_quantity" v-model.number="form['receipt_quantity']"
						v-if="user_group === '管理员' || (form['material_id'] && $check_field('set','receipt_quantity')) || (!form['material_id'] && $check_field('add','receipt_quantity'))"></el-input-number>
					<div v-else-if="$check_field('get','receipt_quantity')">{{form['receipt_quantity']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','warehousing_time') || $check_field('add','warehousing_time') || $check_field('set','warehousing_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="入库时间" prop="warehousing_time">
					<el-date-picker :disabled="disabledObj['warehousing_time_isDisabled']" v-if="user_group === '管理员' || (form['material_id'] && $check_field('set','warehousing_time')) || (!form['material_id'] && $check_field('add','warehousing_time'))" id="warehousing_time"
						v-model="form['warehousing_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','warehousing_time')">{{form['warehousing_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','material_source') || $check_field('add','material_source') || $check_field('set','material_source')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="物资来源" prop="material_source">
					<el-input type="textarea" id="material_source" v-model="form['material_source']" placeholder="请输入物资来源"
						v-if="user_group === '管理员' || (form['material_id'] && $check_field('set','material_source')) || (!form['material_id'] && $check_field('add','material_source'))" :disabled="disabledObj['material_source_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','material_source')">{{form['material_source']}}</div>
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
				field: "material_id",
				url_add: "~/api/material/add?",
				url_set: "~/api/material/set?",
				url_get_obj: "~/api/material/get_obj?",
				url_upload: "~/api/material/upload?",

				query: {
					"material_id": 0,
				},

				form: {
					"material_name":'', // 物资名称
					"material_type":'', // 物资类型
					"receipt_quantity":0, // 入库数量
					"warehousing_time":'', // 入库时间
					"material_source":'', // 物资来源
					"material_id": 0, // ID

				},
				disabledObj:{
					"material_name_isDisabled": false,
					"material_type_isDisabled": false,
					"warehousing_time_isDisabled": false,
					"material_source_isDisabled": false,
				},
			}
		},
		methods: {

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
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
				this.form["warehousing_time"] = this.$toTime(parseInt(this.form["warehousing_time"]),"yyyy-MM-dd hh:mm:ss")
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
        if(this.form["warehousing_time"]=="0000-00-00 00:00:00"){
          this.form["warehousing_time"] = null;
        }
				if(parseInt(this.form["warehousing_time"]) > 9999){
					this.form["warehousing_time"] = this.$toTime(parseInt(this.form["warehousing_time"]),"yyyy-MM-dd hh:mm:ss")
				}
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/material/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/material/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/material/view','get');
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
