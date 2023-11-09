<template>

    <v-data-table
        :headers="headers"
        :items="orderDetail"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDetailView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
                { text: "shopName", value: "shopName" },
                { text: "orderDt", value: "orderDt" },
                { text: "shopId", value: "shopId" },
                { text: "menuLst", value: "menuLst" },
            ],
            orderDetail : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderDetails'))

            temp.data._embedded.orderDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderDetail = temp.data._embedded.orderDetails;
        },
        methods: {
        }
    }
</script>

