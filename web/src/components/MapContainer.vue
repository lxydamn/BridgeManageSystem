<template>
  <el-card class="box-card">
    <div id="container">
    </div>
  </el-card>

</template>

<script lang="ts">
import AMapLoader from '@amap/amap-jsapi-loader';
import { shallowRef } from '@vue/reactivity';
export default {
  setup() {
    const map = shallowRef(null);
    return {
      map,
    }
  },
  methods: {
    ininMap() {

      AMapLoader.load({
        key: "92baa640bf6360c3608edd4ade7f3673",
        version: "2.0", // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        AMapUI: {
          // 是否加载 AMapUI，缺省不加载
          version: "1.1", // AMapUI 缺省 1.1
          plugins: ['misc/PathSimplifier', 'control/BasicControl', 'overlay/SimpleMarker'], // 需要加载的 AMapUI ui插件
        },
        plugins: ["AMap.DistrictLayer", "AMap.Scale", "AMap.ToolBar"],
        Loca: {
          // 是否加载 Loca， 缺省不加载
          version: "2.0.0", // Loca 版本，缺省 2.0.0
        },
      }).then((AMap) => {
        this.map = new AMap.Map("container", {
            //设置地图容器id
            zoom: 4.4, //初始化地图级别
            mapStyle:
              "amap://styles/8389cc93e89d4cf61b6873b24befc228", //设置地图的显示样式
            center: [106.542725, 36.583360], //初始化地图中心点位置//
          });
      })


    },


  },
  mounted() {
    //DOM初始化完成进行地图初始化
    this.ininMap();
  }
}
</script>



<style scoped>
#container {
  width: 100%;
  height: 43em;
}
</style>



<style>
/* 隐藏高德logo  */
.amap-logo {
  display: none !important;
}

/* 隐藏高德版权  */
.amap-copyright {
  display: none !important;
}
</style>