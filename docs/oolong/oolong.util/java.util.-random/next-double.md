[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Random](index.md) / [nextDouble](./next-double.md)

# nextDouble

`fun <Msg> `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`.nextDouble(msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-double.md#Msg)`): `[`Cmd`](../../oolong.platform/-cmd/index.md)`<`[`Msg`](next-double.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/random.kt#L22)

Call [Random.nextDouble](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html#nextDouble()) with a mapping of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg).

### Parameters

`msg` - map function of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-double.md#Msg)

**Return**
[Cmd](../../oolong.platform/-cmd/index.md) of [Msg](next-double.md#Msg) for the generated [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)
