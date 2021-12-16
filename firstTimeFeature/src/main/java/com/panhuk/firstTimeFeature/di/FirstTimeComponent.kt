package com.panhuk.firstTimeFeature.di

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.firstTimeFeature.FirstTimeFragment
import com.panhuk.repositorydi.username.UsernameRepoComponent
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class,
    UsernameRepoComponent::class
  ]
)
interface FirstTimeComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun usernameRepoComponent(component: UsernameRepoComponent): Builder
    fun build(): FirstTimeComponent
  }

  fun inject(firstTimeFragment: FirstTimeFragment)

  companion object {
    fun create(applicationContext: Context): FirstTimeComponent =
      DaggerFirstTimeComponent.builder()
        .coreComponent(CoreComponent.create())
        .usernameRepoComponent(UsernameRepoComponent.create(applicationContext))
        .build()
  }
}