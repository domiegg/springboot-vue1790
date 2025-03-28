import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 权限路由
	{
		path: '/auth/table',
		name: 'auth_table',
		component: () => import('../views/nav/table.vue'),
		meta: {
			index: 0,
			title: '权限列表'
		}
	},
	{
		path: '/auth/view',
		name: 'auth_view',
		component: () => import('../views/nav/view.vue'),
		meta: {
			index: 0,
			title: '权限详情'
		}
	},

	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
	// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},

	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },
	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},
	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},
	// 灾情救援路由
	{
		path: '/disaster_rescue/table',
		name: 'disaster_rescue_table',
		component: () => import('../views/disaster_rescue/table.vue')
	},
	{
		path: '/disaster_rescue/view',
		name: 'disaster_rescue_view',
		component: () => import('../views/disaster_rescue/view.vue')
	},
	// 普通用户路由
	{
		path: '/ordinary_users/table',
		name: 'ordinary_users_table',
		component: () => import('../views/ordinary_users/table.vue')
	},
	{
		path: '/ordinary_users/view',
		name: 'ordinary_users_view',
		component: () => import('../views/ordinary_users/view.vue')
	},
	// 审核员路由
	{
		path: '/auditor/table',
		name: 'auditor_table',
		component: () => import('../views/auditor/table.vue')
	},
	{
		path: '/auditor/view',
		name: 'auditor_view',
		component: () => import('../views/auditor/view.vue')
	},
	// 救援计划路由
	{
		path: '/rescue_plan/table',
		name: 'rescue_plan_table',
		component: () => import('../views/rescue_plan/table.vue')
	},
	{
		path: '/rescue_plan/view',
		name: 'rescue_plan_view',
		component: () => import('../views/rescue_plan/view.vue')
	},
	// 调度方案路由
	{
		path: '/scheduling_scheme/table',
		name: 'scheduling_scheme_table',
		component: () => import('../views/scheduling_scheme/table.vue')
	},
	{
		path: '/scheduling_scheme/view',
		name: 'scheduling_scheme_view',
		component: () => import('../views/scheduling_scheme/view.vue')
	},
	// 灾情分类路由
	{
		path: '/disaster_classification/table',
		name: 'disaster_classification_table',
		component: () => import('../views/disaster_classification/table.vue')
	},
	{
		path: '/disaster_classification/view',
		name: 'disaster_classification_view',
		component: () => import('../views/disaster_classification/view.vue')
	},
	// 物资分类路由
	{
		path: '/material_classification/table',
		name: 'material_classification_table',
		component: () => import('../views/material_classification/table.vue')
	},
	{
		path: '/material_classification/view',
		name: 'material_classification_view',
		component: () => import('../views/material_classification/view.vue')
	},
	// 物资管理路由
	{
		path: '/material_management/table',
		name: 'material_management_table',
		component: () => import('../views/material_management/table.vue')
	},
	{
		path: '/material_management/view',
		name: 'material_management_view',
		component: () => import('../views/material_management/view.vue')
	},
	// 物资入库路由
	{
		path: '/material/table',
		name: 'material_table',
		component: () => import('../views/material/table.vue')
	},
	{
		path: '/material/view',
		name: 'material_view',
		component: () => import('../views/material/view.vue')
	},
	// 物资发放路由
	{
		path: '/material_distribution/table',
		name: 'material_distribution_table',
		component: () => import('../views/material_distribution/table.vue')
	},
	{
		path: '/material_distribution/view',
		name: 'material_distribution_view',
		component: () => import('../views/material_distribution/view.vue')
	},
	// 物资库存路由
	{
		path: '/material_inventory/table',
		name: 'material_inventory_table',
		component: () => import('../views/material_inventory/table.vue')
	},
	{
		path: '/material_inventory/view',
		name: 'material_inventory_view',
		component: () => import('../views/material_inventory/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "灾情救援系统-admin";
	document.title = title;
})

export default router
