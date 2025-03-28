<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="灾情资讯"
				source_table="article"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/auditor/list', 'get')"
				:list="result_auditor_personnel_number"
				title="审核员人员编号"
				source_table="auditor"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/rescue_plan/list', 'get')"
				:list="result_rescue_plan_user_name"
				title="救援计划用户姓名"
				source_table="rescue_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/rescue_plan/list', 'get')"
				:list="result_rescue_plan_plan_name"
				title="救援计划计划名称"
				source_table="rescue_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/rescue_plan/list', 'get')"
				:list="result_rescue_plan_plan_type"
				title="救援计划计划类型"
				source_table="rescue_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/rescue_plan/list', 'get')"
				:list="result_rescue_plan_degree_of_urgency"
				title="救援计划紧急程度"
				source_table="rescue_plan"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/scheduling_scheme/list', 'get')"
				:list="result_scheduling_scheme_plan_name"
				title="调度方案计划名称"
				source_table="scheduling_scheme"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/scheduling_scheme/list', 'get')"
				:list="result_scheduling_scheme_plan_type"
				title="调度方案计划类型"
				source_table="scheduling_scheme"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/scheduling_scheme/list', 'get')"
				:list="result_scheduling_scheme_degree_of_urgency"
				title="调度方案紧急程度"
				source_table="scheduling_scheme"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/scheduling_scheme/list', 'get')"
				:list="result_scheduling_scheme_rescue_name"
				title="调度方案救援名称"
				source_table="scheduling_scheme"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/scheduling_scheme/list', 'get')"
				:list="result_scheduling_scheme_rescue_type"
				title="调度方案救援类型"
				source_table="scheduling_scheme"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_management/list', 'get')"
				:list="result_material_management_material_name"
				title="物资管理物资名称"
				source_table="material_management"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_management/list', 'get')"
				:list="result_material_management_material_type"
				title="物资管理物资类型"
				source_table="material_management"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material/list', 'get')"
				:list="result_material_material_name"
				title="物资入库物资名称"
				source_table="material"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material/list', 'get')"
				:list="result_material_material_type"
				title="物资入库物资类型"
				source_table="material"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_distribution/list', 'get')"
				:list="result_material_distribution_material_name"
				title="物资发放物资名称"
				source_table="material_distribution"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_distribution/list', 'get')"
				:list="result_material_distribution_material_type"
				title="物资发放物资类型"
				source_table="material_distribution"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_inventory/list', 'get')"
				:list="result_material_inventory_material_name"
				title="物资库存物资名称"
				source_table="material_inventory"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/material_inventory/list', 'get')"
				:list="result_material_inventory_material_type"
				title="物资库存物资类型"
				source_table="material_inventory"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
			"result_auditor_personnel_number":[],
			"result_rescue_plan_user_name":[],
			"result_rescue_plan_plan_name":[],
			"result_rescue_plan_plan_type":[],
			"result_rescue_plan_degree_of_urgency":[],
			"result_scheduling_scheme_plan_name":[],
			"result_scheduling_scheme_plan_type":[],
			"result_scheduling_scheme_degree_of_urgency":[],
			"result_scheduling_scheme_rescue_name":[],
			"result_scheduling_scheme_rescue_type":[],
			"result_material_management_material_name":[],
			"result_material_management_material_type":[],
			"result_material_material_name":[],
			"result_material_material_type":[],
			"result_material_distribution_material_name":[],
			"result_material_distribution_material_type":[],
			"result_material_inventory_material_name":[],
			"result_material_inventory_material_type":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取personnel_number
	 */
	get_auditor_personnel_number(){
		this.$get("~/api/auditor/get_list?like=0", { page: 1, size: 10, "personnel_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_auditor_personnel_number = json.result.list;
			result_auditor_personnel_number.map(o => o.title = o['personnel_number'])
	  			this.result_auditor_personnel_number = result_auditor_personnel_number
		 	}
		});
	},
	/**
	 * 获取user_name
	 */
	get_rescue_plan_user_name(){
		this.$get("~/api/rescue_plan/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_plan_user_name = json.result.list;
			result_rescue_plan_user_name.map(o => o.title = o['user_name'])
	  			this.result_rescue_plan_user_name = result_rescue_plan_user_name
		 	}
		});
	},
	/**
	 * 获取plan_name
	 */
	get_rescue_plan_plan_name(){
		this.$get("~/api/rescue_plan/get_list?like=0", { page: 1, size: 10, "plan_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_plan_plan_name = json.result.list;
			result_rescue_plan_plan_name.map(o => o.title = o['plan_name'])
	  			this.result_rescue_plan_plan_name = result_rescue_plan_plan_name
		 	}
		});
	},
	/**
	 * 获取plan_type
	 */
	get_rescue_plan_plan_type(){
		this.$get("~/api/rescue_plan/get_list?like=0", { page: 1, size: 10, "plan_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_plan_plan_type = json.result.list;
			result_rescue_plan_plan_type.map(o => o.title = o['plan_type'])
	  			this.result_rescue_plan_plan_type = result_rescue_plan_plan_type
		 	}
		});
	},
	/**
	 * 获取degree_of_urgency
	 */
	get_rescue_plan_degree_of_urgency(){
		this.$get("~/api/rescue_plan/get_list?like=0", { page: 1, size: 10, "degree_of_urgency": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_plan_degree_of_urgency = json.result.list;
			result_rescue_plan_degree_of_urgency.map(o => o.title = o['degree_of_urgency'])
	  			this.result_rescue_plan_degree_of_urgency = result_rescue_plan_degree_of_urgency
		 	}
		});
	},
	/**
	 * 获取plan_name
	 */
	get_scheduling_scheme_plan_name(){
		this.$get("~/api/scheduling_scheme/get_list?like=0", { page: 1, size: 10, "plan_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_scheduling_scheme_plan_name = json.result.list;
			result_scheduling_scheme_plan_name.map(o => o.title = o['plan_name'])
	  			this.result_scheduling_scheme_plan_name = result_scheduling_scheme_plan_name
		 	}
		});
	},
	/**
	 * 获取plan_type
	 */
	get_scheduling_scheme_plan_type(){
		this.$get("~/api/scheduling_scheme/get_list?like=0", { page: 1, size: 10, "plan_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_scheduling_scheme_plan_type = json.result.list;
			result_scheduling_scheme_plan_type.map(o => o.title = o['plan_type'])
	  			this.result_scheduling_scheme_plan_type = result_scheduling_scheme_plan_type
		 	}
		});
	},
	/**
	 * 获取degree_of_urgency
	 */
	get_scheduling_scheme_degree_of_urgency(){
		this.$get("~/api/scheduling_scheme/get_list?like=0", { page: 1, size: 10, "degree_of_urgency": this.query.word }, (json) => {
		  if (json.result) {
			var result_scheduling_scheme_degree_of_urgency = json.result.list;
			result_scheduling_scheme_degree_of_urgency.map(o => o.title = o['degree_of_urgency'])
	  			this.result_scheduling_scheme_degree_of_urgency = result_scheduling_scheme_degree_of_urgency
		 	}
		});
	},
	/**
	 * 获取rescue_name
	 */
	get_scheduling_scheme_rescue_name(){
		this.$get("~/api/scheduling_scheme/get_list?like=0", { page: 1, size: 10, "rescue_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_scheduling_scheme_rescue_name = json.result.list;
			result_scheduling_scheme_rescue_name.map(o => o.title = o['rescue_name'])
	  			this.result_scheduling_scheme_rescue_name = result_scheduling_scheme_rescue_name
		 	}
		});
	},
	/**
	 * 获取rescue_type
	 */
	get_scheduling_scheme_rescue_type(){
		this.$get("~/api/scheduling_scheme/get_list?like=0", { page: 1, size: 10, "rescue_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_scheduling_scheme_rescue_type = json.result.list;
			result_scheduling_scheme_rescue_type.map(o => o.title = o['rescue_type'])
	  			this.result_scheduling_scheme_rescue_type = result_scheduling_scheme_rescue_type
		 	}
		});
	},
	/**
	 * 获取material_name
	 */
	get_material_management_material_name(){
		this.$get("~/api/material_management/get_list?like=0", { page: 1, size: 10, "material_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_management_material_name = json.result.list;
			result_material_management_material_name.map(o => o.title = o['material_name'])
	  			this.result_material_management_material_name = result_material_management_material_name
		 	}
		});
	},
	/**
	 * 获取material_type
	 */
	get_material_management_material_type(){
		this.$get("~/api/material_management/get_list?like=0", { page: 1, size: 10, "material_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_management_material_type = json.result.list;
			result_material_management_material_type.map(o => o.title = o['material_type'])
	  			this.result_material_management_material_type = result_material_management_material_type
		 	}
		});
	},
	/**
	 * 获取material_name
	 */
	get_material_material_name(){
		this.$get("~/api/material/get_list?like=0", { page: 1, size: 10, "material_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_material_name = json.result.list;
			result_material_material_name.map(o => o.title = o['material_name'])
	  			this.result_material_material_name = result_material_material_name
		 	}
		});
	},
	/**
	 * 获取material_type
	 */
	get_material_material_type(){
		this.$get("~/api/material/get_list?like=0", { page: 1, size: 10, "material_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_material_type = json.result.list;
			result_material_material_type.map(o => o.title = o['material_type'])
	  			this.result_material_material_type = result_material_material_type
		 	}
		});
	},
	/**
	 * 获取material_name
	 */
	get_material_distribution_material_name(){
		this.$get("~/api/material_distribution/get_list?like=0", { page: 1, size: 10, "material_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_distribution_material_name = json.result.list;
			result_material_distribution_material_name.map(o => o.title = o['material_name'])
	  			this.result_material_distribution_material_name = result_material_distribution_material_name
		 	}
		});
	},
	/**
	 * 获取material_type
	 */
	get_material_distribution_material_type(){
		this.$get("~/api/material_distribution/get_list?like=0", { page: 1, size: 10, "material_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_distribution_material_type = json.result.list;
			result_material_distribution_material_type.map(o => o.title = o['material_type'])
	  			this.result_material_distribution_material_type = result_material_distribution_material_type
		 	}
		});
	},
	/**
	 * 获取material_name
	 */
	get_material_inventory_material_name(){
		this.$get("~/api/material_inventory/get_list?like=0", { page: 1, size: 10, "material_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_inventory_material_name = json.result.list;
			result_material_inventory_material_name.map(o => o.title = o['material_name'])
	  			this.result_material_inventory_material_name = result_material_inventory_material_name
		 	}
		});
	},
	/**
	 * 获取material_type
	 */
	get_material_inventory_material_type(){
		this.$get("~/api/material_inventory/get_list?like=0", { page: 1, size: 10, "material_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_material_inventory_material_type = json.result.list;
			result_material_inventory_material_type.map(o => o.title = o['material_type'])
	  			this.result_material_inventory_material_type = result_material_inventory_material_type
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
		this.get_auditor_personnel_number();
		this.get_rescue_plan_user_name();
		this.get_rescue_plan_plan_name();
		this.get_rescue_plan_plan_type();
		this.get_rescue_plan_degree_of_urgency();
		this.get_scheduling_scheme_plan_name();
		this.get_scheduling_scheme_plan_type();
		this.get_scheduling_scheme_degree_of_urgency();
		this.get_scheduling_scheme_rescue_name();
		this.get_scheduling_scheme_rescue_type();
		this.get_material_management_material_name();
		this.get_material_management_material_type();
		this.get_material_material_name();
		this.get_material_material_type();
		this.get_material_distribution_material_name();
		this.get_material_distribution_material_type();
		this.get_material_inventory_material_name();
		this.get_material_inventory_material_type();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_auditor_personnel_number();
	  this.get_rescue_plan_user_name();
	  this.get_rescue_plan_plan_name();
	  this.get_rescue_plan_plan_type();
	  this.get_rescue_plan_degree_of_urgency();
	  this.get_scheduling_scheme_plan_name();
	  this.get_scheduling_scheme_plan_type();
	  this.get_scheduling_scheme_degree_of_urgency();
	  this.get_scheduling_scheme_rescue_name();
	  this.get_scheduling_scheme_rescue_type();
	  this.get_material_management_material_name();
	  this.get_material_management_material_type();
	  this.get_material_material_name();
	  this.get_material_material_type();
	  this.get_material_distribution_material_name();
	  this.get_material_distribution_material_type();
	  this.get_material_inventory_material_name();
	  this.get_material_inventory_material_type();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
