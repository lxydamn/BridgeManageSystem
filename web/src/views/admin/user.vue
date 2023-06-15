<template>
    <a-button class="operator-btn" @click="visible = true">添加用户</a-button>

    <a-table :columns="columns" :data-source="dataSource">
        <template #bodyCell="{column, record}">
            <template v-if="column.dataIndex === 'operation'">
                <a-popconfirm
                    v-if="dataSource.length"
                    title="确认要删除吗？"
                    ok-text="确认"
                    cancel-text="取消"
                    @confirm="onDelete(record.account)"
                >
                  <a>删除</a>
                </a-popconfirm>
              </template>
        </template>
    </a-table>

    <a-modal
        v-model:visible="visible"
        title="用户"
        ok-text="确认"
        cancel-text="取消"
        @ok="handleOk"
    >
        <a-input class="input-cpn" v-model:value="modalValue.username" placeholder="用户名" />
        <a-input class="input-cpn" v-model:value="modalValue.password" placeholder="密码" />
        <a-select
            class="input-cpn"
            ref="select"
            v-model:value="modalValue.unit_no"
            style="width: 10em"
            :options="units"
            :field-names="{label:'unit_name', value:'unit_no'}"
        ></a-select>
        <a-input pattern="[0-9]*" class="input-cpn" v-model:value="modalValue.tellphone" placeholder="电话" />
    </a-modal>
</template>
<script lang="ts">
import axios from 'axios';
import { Ref, defineComponent, reactive, ref } from 'vue';
import '../../utils/errorMessage'
import {error_message} from '../../utils/errorMessage';
const columns = [
    {
        title: '用户名',
        dataIndex: 'username',
    },
    {
        title: '账号',
        dataIndex: 'account',
    },
    {
        title: '单位',
        dataIndex: 'unit_name',
        ellipsis: true,
    },
    {
        title: '电话',
        dataIndex: 'tellphone',
        ellipsis: true,
    },
    {
        title: '操作',
        dataIndex: 'operation',
    },
    
];

interface User {
    account: string
    username: string
    unit_name: string
    tellphone: string
}

export default defineComponent({
    components: {

    },

    setup() {
        let visible = ref(false)
        const dataSource: Ref<User[]> = ref([])

        let units = ref([])

        const checkInput = () => {
            if (modalValue.tellphone.length == 0 || modalValue.username.length == 0 ||
                modalValue.unit_no.length == 0 || modalValue.password.length == 0
            ) return false

            return true
        }

        const cleanInput = () => {
            modalValue.username = ""
            modalValue.password = ""
            modalValue.unit_no = ""
            modalValue.account = ""
        }

        const modalValue = reactive({
            username:'',
            account:'',
            password:'',
            unit_no:'',
            tellphone:'',
        })

        const getUnits = () => {
            axios({
                url: 'http://localhost:3000/api/unit/get/all',
                method:'GET',
            }).then((resp) => {
                units.value = resp.data
            })
        }
        getUnits()

        const getUsers = () => {
            axios({
                url:'http://localhost:3000/api/user/get/all',
                method:'GET',
            }).then((resp) => {
                dataSource.value = resp.data
            })
        }
        getUsers()

        const handleOk = () => {

            if (! checkInput() ) {
                error_message("请规范输入内容", "error");
                return
            }

            axios({
                url:'http://localhost:3000/api/user/register',
                method:"POST",
                params:{
                    username:modalValue.username,
                    password:modalValue.password,
                    unit_no:modalValue.unit_no,
                    tellphone:modalValue.tellphone,
                }
            }).then((resp) => {
                if (resp.data.error_info === 'success') {
                    error_message("成功", "success")
                    visible.value = false
                    cleanInput()
                    getUsers()
                } else {
                    error_message(resp.data.error_info, "error")
                }
            })
        }

        const onDelete = (account : any) => {

            console.log(account)
            axios({
                url:'http://localhost:3000/api/user/delete',
                method:"POST",
                params: {
                    account: account,
                }
            }).then((resp) => {
                console.log(resp.data)
                error_message(resp.data.error_info, resp.data.error_info)
                getUsers()
            })
        }

        return {
            columns,
            dataSource,
            modalValue,
            handleOk,
            visible,
            units,
            onDelete,
        };
    },
});
</script>

<style>
    .operator-btn {
        margin-bottom: .8em;
        height: 3em;
    }
    .input-cpn {
        margin: .5em;
        height: 2.5em;
    }
</style>
  
  