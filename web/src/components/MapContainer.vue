<template>
    <div id="container">
    </div>
</template>

<script lang="ts">
import AMapLoader from '@amap/amap-jsapi-loader';
import { shallowRef } from '@vue/reactivity';
import axios from 'axios';
import { reactive } from 'vue';
import { useUserStore } from '../store/user';

const userStore= useUserStore()

export default {
  setup() {
    const map = shallowRef();
    const bridgeLL = reactive({
      data: [
          {
            bridge_no:'',
            bridge_name:'',
            route_name:'',
            type_name:'',
            lati:'',
            longi:'',
       }
      ]
    })
    return {
      map,
      bridgeLL,
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
            zoom: 6, //初始化地图级别
            mapStyle:
              "amap://styles/8389cc93e89d4cf61b6873b24befc228", //设置地图的显示样式
            center: [106.505, 29.5332], //初始化地图中心点位置//
          });
        
          for (let i of this.bridgeLL.data) {
            var marker = new AMap.Marker({
              position:[i.lati, i.longi],
              icon:'https://img1.imgtp.com/2023/06/27/DU9XCGE0.png',
              text:i.bridge_name,
              map:this.map,
              title: i.bridge_name
            })
            marker.bridgeData = i
            marker.on('click', openInfo)
            this.map.add(marker)
            
          }
          function openInfo(e : any) {
              var info = [];
              info.push("<p class='input-item'> 桥梁名称   ：" + e.target.bridgeData.bridge_name + "</p>");
              info.push("<p class='input-item'> 桥梁编号   ：" + e.target.bridgeData.bridge_no + "</p>");
              info.push("<p class='input-item'> 桥梁类型   ：" + e.target.bridgeData.bridge_no + "</p>");
              info.push("<p class='input-item'> 路线   ：" + e.target.bridgeData.route_name + "</p>");
              info.push("<p class='input-item'> 经纬度   ：" + e.target.bridgeData.lati + "，" + e.target.bridgeData.longi + "</p>");
              let infoWindow = new AMap.InfoWindow({
                  content: info.join("")  //使用默认信息窗体框样式，显示信息内容
              });
              infoWindow.open(e.target._map, e.target._position)
          }
      })
    },
    
    getBridgeLL() {
      axios({
        url:"http://localhost:3000/api/bridge/get/ll",
        method:"GET",
        params: {
          unit_no: userStore.unit_no,
        }
      }).then((resp) => {
        this.bridgeLL.data = resp.data
        this.ininMap()
      })
    }

  },
  mounted() {
    //DOM初始化完成进行地图初始化
    this.getBridgeLL();
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
.input-item {
  margin: 1em;
}
/* 隐藏高德版权  */
.amap-copyright {
  display: none !important;
}
</style>