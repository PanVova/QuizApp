package com.panhuk.dataSourceimpl.question

import com.panhuk.api.api.QuestionApi
import com.panhuk.datasource.QuestionDSReader
import com.panhuk.domain.model.Category
import com.panhuk.domain.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionApiDataSource(private val api: QuestionApi) : QuestionDSReader {
  override fun getQuestions(
    amount: Int,
    categoryId: String?,
    difficulty: String?,
    type: String?,
    token: String?
  ): Flow<List<Question>?> = flow {
    emit(
      api.getQuestions(amount, categoryId, difficulty, type, token).results.map { questionDTO ->
        questionDTO.mapToDomain()
      }
    )
  }

  override val categories: Flow<List<Category>>
    get() = flow {
      emit(
        api.getCategories().triviaResponse.map { categoryDTO ->
          categoryDTO.mapToDomain()
        }
      )
    }
}