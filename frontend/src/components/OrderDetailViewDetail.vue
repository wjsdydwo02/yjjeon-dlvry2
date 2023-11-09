<template>

    <v-card outlined>
        <v-card-title>
            OrderDetail # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="OrderStatus" v-model="item.orderStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DeliveryStatus" v-model="item.deliveryStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ShopName" v-model="item.shopName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OrderDt" v-model="item.orderDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ShopId" v-model="item.shopId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuLst" v-model="item.menuLst" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderDetailViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderDetails/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

