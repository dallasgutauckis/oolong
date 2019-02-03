package oolong.util

import oolong.Dispatch
import oolong.platform.Effect
import java.util.Date
import java.util.Timer
import java.util.TimerTask

/**
 * Call [Timer.schedule] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.schedule(time: Date, msg: (Long) -> Msg) = Effect<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), time)
}

/**
 * Call [Timer.schedule] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.schedule(firstTime: Date, period: Long, msg: (Long) -> Msg) =
    Effect<Msg> { dispatch ->
        schedule(timerTask(dispatch, msg), firstTime, period)
    }

/**
 * Call [Timer.schedule] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.schedule(delay: Long, msg: (Long) -> Msg) = Effect<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), delay)
}

/**
 * Call [Timer.schedule] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.schedule(delay: Long, period: Long, msg: (Long) -> Msg) = Effect<Msg> { dispatch ->
    schedule(timerTask(dispatch, msg), delay, period)
}

/**
 * Call [Timer.scheduleAtFixedRate] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.scheduleAtFixedRate(firstTime: Date, period: Long, msg: (Long) -> Msg) =
    Effect<Msg> { dispatch ->
        scheduleAtFixedRate(timerTask(dispatch, msg), firstTime, period)
    }

/**
 * Call [Timer.scheduleAtFixedRate] with a mapping of [Long] to [Msg].
 *
 * @param msg map function of [Long] to [Msg]
 * @return [Sub] of [Msg] for the generated [Long]
 */
fun <Msg> Timer.scheduleAtFixedRate(delay: Long, period: Long, msg: (Long) -> Msg) =
    Effect<Msg> { dispatch ->
        scheduleAtFixedRate(timerTask(dispatch, msg), delay, period)
    }

private fun <Msg> timerTask(dispatch: Dispatch<Msg>, msg: (Long) -> Msg): TimerTask {
    return object : TimerTask() {
        override fun run() {
            dispatch(msg(System.currentTimeMillis()))
        }
    }
}