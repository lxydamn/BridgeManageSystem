<template>
	<adminNavbar></adminNavbar>
	<div class="container">
		<div class="sider-box">
			<adminSider></adminSider>
		</div>
		<div class="content-box">
			<RouterView v-slot="{ Component }" :key="$route.fullPath">
				<component :is="Component"></component>
			</RouterView>
		</div>
	</div>
</template>
<script lang="ts">
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
import adminSider from '../../components/adminSider.vue';
import adminNavbar from '../../components/adminNavbar.vue';
import { defineComponent, ref } from 'vue';
export default defineComponent({
	components: {
		UserOutlined,
		adminSider,
		adminNavbar,
		LaptopOutlined,
		NotificationOutlined,
	},
	setup() {
		return {
			selectedKeys1: ref<string[]>(['2']),
			selectedKeys2: ref<string[]>(['1']),
			collapsed: ref<boolean>(false),
			openKeys: ref<string[]>(['sub1']),
		};
	},
});
</script>
<style scoped>
.container {
	display: flex;
}

.sider-box {
	width: 15%;
}

.content-box {
	width: 85%;
	height: 90vh;
	padding: 1em;
	overflow: hidden auto;
	background-color: rgb(239, 238, 238);
}
</style>
  