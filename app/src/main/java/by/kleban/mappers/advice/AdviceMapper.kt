package by.kleban.mappers.advice

import by.kleban.data.dto.advice.AdviceResponse
import by.kleban.data.entities.advice.Advice
import com.bignerdranch.android.a1305network.mappers.Mapper


class AdviceMapper: Mapper<AdviceResponse,Advice> {
    override fun map(from: AdviceResponse): Advice {
      return  Advice(from.slip?.advice.orEmpty())
    }
}