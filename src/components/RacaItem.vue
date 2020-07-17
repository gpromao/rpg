<template>
    <li @click="tratarClick">
        {{ value }}
    </li>
</template>

<script>
    export default {
        name: 'RacaItem',
        props: {
            value: String
        }
    }
</script>