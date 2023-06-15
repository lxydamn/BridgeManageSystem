import axios from "axios";

export function getUnits(units : any) {
    axios({
        url: 'http://localhost:3000/api/unit/get/all',
        method:'GET',
    }).then((resp) => {
        units = resp.data
    })
}