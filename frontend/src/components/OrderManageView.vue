<template>

    <v-data-table
        :headers="headers"
        :items="orderManage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderManageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            orderManage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderManages'))

            temp.data._embedded.orderManages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderManage = temp.data._embedded.orderManages;
        },
        methods: {
        }
    }
</script>

