import { defineStore } from "pinia";
import router from "../router";
import { pinia } from ".";
export const useUserStore = defineStore('user', {
    persist: true,
    state: () => {
        return {
            account:"",
            username:'',
            unit_no:"",
            unit_name:'',
            is_login:false,
        }
    },
    actions: {
        logout() {
            this.account=""
            this.is_login=false
            this.username=""
            this.unit_no = ""
            this.unit_name = ''
            sessionStorage.removeItem("is_login")
            router.push({name:'login'})
        }
    }
})

export function useUserStoreWithOut() {
    return useUserStore(pinia)
}
  