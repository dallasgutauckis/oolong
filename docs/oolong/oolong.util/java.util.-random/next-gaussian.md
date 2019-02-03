[oolong](../../index.md) / [oolong.util](../index.md) / [java.util.Random](index.md) / [nextGaussian](./next-gaussian.md)

# nextGaussian

`fun <Msg> `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`.nextGaussian(msg: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Msg`](next-gaussian.md#Msg)`): `[`Cmd`](../../oolong.platform/-cmd/index.md)`<`[`Msg`](next-gaussian.md#Msg)`>` [(source)](https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin/oolong/util/random.kt#L42)

Call [Random.nextGaussianDouble](#) with a mapping of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-gaussian.md#Msg).

### Parameters

`msg` - map function of [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) to [Msg](next-gaussian.md#Msg)

**Return**
[Cmd](../../oolong.platform/-cmd/index.md) of [Msg](next-gaussian.md#Msg) for the generated [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)
