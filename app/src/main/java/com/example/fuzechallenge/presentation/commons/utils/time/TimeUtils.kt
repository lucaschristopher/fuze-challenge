package com.example.fuzechallenge.presentation.commons.utils.time

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.fuzechallenge.R
import com.example.fuzechallenge.commons.constants.Constants.DATE_COMPLEX_PATTERN
import com.example.fuzechallenge.commons.constants.Constants.DATE_SINGLE_PATTERN
import com.example.fuzechallenge.commons.constants.Constants.SPACE_STRING
import com.example.fuzechallenge.commons.constants.Constants.ZONE_OFFSET
import com.example.fuzechallenge.presentation.commons.model.MatchStatus
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal class TimeUtils {

    companion object {

        @Composable
        fun formatTime(matchStatus: String, scheduledAt: String): String {
            // Parse it to an OffsetDateTime (Z == UTC == +00:00 offset)
            val offsetDateTime = OffsetDateTime.parse(scheduledAt)
            // or parse it to a ZonedDateTime
            val zonedDateTime = ZonedDateTime.parse(scheduledAt)

            // Adjust both to a different offset
            // val localZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(ZONE_ID))
            val localOffsetDateTime =
                offsetDateTime.withOffsetSameInstant(ZoneOffset.ofHours(ZONE_OFFSET))

            if (matchStatus == MatchStatus.RUNNING.status)
                return stringResource(id = R.string.now_label).uppercase()

            // Else, check date
            val scheduledTime = localOffsetDateTime.format(
                DateTimeFormatter.ofPattern(DATE_SINGLE_PATTERN)
            )

            return if (getCurrentTime() == scheduledTime) {
                stringResource(
                    id = R.string.today_time,
                    scheduledTime.toString().apply {
                        substring(this.indexOf(SPACE_STRING), this.length - 1)
                    }
                )
            } else {
                stringResource(
                    id = R.string.scheduled_time,
                    scheduledTime.toString()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                )
            }
        }

        private fun getCurrentTime() =
            SimpleDateFormat(
                DATE_COMPLEX_PATTERN,
                java.util.Locale("PT", "br")
            ).toString()
    }

}