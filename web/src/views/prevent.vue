<template>
    <div class="error-page">
        <div class="notfound-box">
            <img src="../assets/images/4.png" alt="back" />
            <img src="../assets/images/0.png" alt="back" />
            <img src="../assets/images/3.png" alt="back" />
        </div>
        <h1 class="response-message">你的权限不足</h1>
    </div>
    
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    components:{
        
    },
    setup() {

    }
})
</script>

<style scoped>  
    .notfound-box{
        display: flex;
        justify-content: center;
        align-items: center;
        height: 50vh;
    }
    .notfound-box img {
        width: 30vh;
        height: 30vh;
    }
</style>